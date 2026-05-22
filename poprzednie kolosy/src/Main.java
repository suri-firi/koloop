import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// ====================================================================
// ROZWIĄZANIA KOLOKWIUM 2021 (COVID-19)
// ====================================================================

class CountryNotFoundException extends Exception {
    public CountryNotFoundException(String countryName) {
        super(countryName);
    }
}

abstract class Country {
    private final String name;
    private static String confirmedCsv;
    private static String deathsCsv;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void setFiles(String confirmed, String deaths) throws FileNotFoundException {
        if (!new File(confirmed).exists()) throw new FileNotFoundException(confirmed);
        if (!new File(deaths).exists()) throw new FileNotFoundException(deaths);
        confirmedCsv = confirmed;
        deathsCsv = deaths;
    }

    protected static class CountryColumns {
        public final int firstColumnIndex;
        public final int columnCount;

        public CountryColumns(int firstColumnIndex, int columnCount) {
            this.firstColumnIndex = firstColumnIndex;
            this.columnCount = columnCount;
        }
    }

    public abstract int getConfirmedCases(LocalDate date);
    public abstract int getDeaths(LocalDate date);
    public abstract void addDailyStatistic(LocalDate date, int confirmed, int deaths);

    public static void sortByDeaths(List<Country> countries, LocalDate start, LocalDate end) {
        countries.sort((c1, c2) -> {
            int deaths1 = 0, deaths2 = 0;
            for (LocalDate d = start; !d.isAfter(end); d = d.plusDays(1)) {
                deaths1 += c1.getDeaths(d);
                deaths2 += c2.getDeaths(d);
            }
            return Integer.compare(deaths2, deaths1);
        });
    }
}

class CountryWithoutProvinces extends Country {
    private final Map<LocalDate, Integer> dailyConfirmed = new HashMap<>();
    private final Map<LocalDate, Integer> dailyDeaths = new HashMap<>();

    public CountryWithoutProvinces(String name) {
        super(name);
    }

    @Override
    public void addDailyStatistic(LocalDate date, int confirmed, int deaths) {
        dailyConfirmed.put(date, confirmed);
        dailyDeaths.put(date, deaths);
    }

    @Override
    public int getConfirmedCases(LocalDate date) {
        return dailyConfirmed.getOrDefault(date, 0);
    }

    @Override
    public int getDeaths(LocalDate date) {
        return dailyDeaths.getOrDefault(date, 0);
    }
}

class CountryWithProvinces extends Country {
    private final Country[] provinces;

    public CountryWithProvinces(String name, Country[] provinces) {
        super(name);
        this.provinces = provinces;
    }

    @Override
    public void addDailyStatistic(LocalDate date, int confirmed, int deaths) {
    }

    @Override
    public int getConfirmedCases(LocalDate date) {
        int sum = 0;
        for (Country province : provinces) {
            sum += province.getConfirmedCases(date);
        }
        return sum;
    }

    @Override
    public int getDeaths(LocalDate date) {
        int sum = 0;
        for (Country province : provinces) {
            sum += province.getDeaths(date);
        }
        return sum;
    }
}

// ====================================================================
// ROZWIĄZANIA KOLOKWIUM 2023 (MAPY, GEOMETRIA, SVG)
// ====================================================================

record Point(double x, double y) {}

class Polygon {
    protected List<Point> points;

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public boolean inside(Point point) {
        int counter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point pa = points.get(i);
            Point pb = points.get((i + 1) % points.size());

            if (pa.y() > pb.y()) {
                Point temp = pa;
                pa = pb;
                pb = temp;
            }

            if (pa.y() < point.y() && point.y() < pb.y()) {
                double d = pb.x() - pa.x();
                double x;
                if (d == 0) {
                    x = pa.x();
                } else {
                    double a = (pb.y() - pa.y()) / d;
                    double b = pa.y() - a * pa.x();
                    x = (point.y() - b) / a;
                }

                if (x < point.x()) {
                    counter++;
                }
            }
        }
        return counter % 2 != 0;
    }
}

class Land extends Polygon {
    private final List<City> cities = new ArrayList<>();

    public Land(List<Point> points) {
        super(points);
    }

    public void addCity(City city) {
        if (this.inside(city.center)) {
            cities.add(city);
        } else {
            throw new RuntimeException(city.name);
        }
    }
}

class Resource {
    public enum Type { COAL, WOOD, FISH }

    public final Point point;
    public final Type type;

    public Resource(Point point, Type type) {
        this.point = point;
        this.type = type;
    }
}

class City extends Polygon {
    public final Point center;
    public String name;
    private boolean port = false;
    Set<Resource.Type> resources = new HashSet<>();

    public City(Point center, String name, double wallLength) {
        super(List.of(
                new Point(center.x() - wallLength / 2, center.y() - wallLength / 2),
                new Point(center.x() + wallLength / 2, center.y() - wallLength / 2),
                new Point(center.x() + wallLength / 2, center.y() + wallLength / 2),
                new Point(center.x() - wallLength / 2, center.y() + wallLength / 2)
        ));
        this.center = center;
        this.name = name;
    }

    public void checkPort(Land land) {
        for (Point p : this.points) {
            if (!land.inside(p)) {
                this.port = true;
                break;
            }
        }
    }

    public void addResourcesInRange(List<Resource> allResources, double range) {
        for (Resource r : allResources) {
            double distance = Math.sqrt(Math.pow(r.point.x() - center.x(), 2) + Math.pow(r.point.y() - center.y(), 2));
            if (distance <= range) {
                if (r.type == Resource.Type.FISH && !this.port) continue;
                resources.add(r.type);
            }
        }
    }
}

// ====================================================================
// ROZWIĄZANIA KOLOKWIUM 2024 (ZEGARY)
// ====================================================================

abstract class Clock {
    protected LocalTime time;

    public void setCurrentTime() {
        this.time = LocalTime.now();
    }

    public void setTime(int h, int m, int s) {
        if (h < 0 || h > 23) throw new IllegalArgumentException("Zła godzina (0-23): " + h);
        if (m < 0 || m > 59) throw new IllegalArgumentException("Zła minuta (0-59): " + m);
        if (s < 0 || s > 59) throw new IllegalArgumentException("Zła sekunda (0-59): " + s);
        this.time = LocalTime.of(h, m, s);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond());
    }
}

class DigitalClock extends Clock {
    public enum Format { H12, H24 }
    private final Format format;

    public DigitalClock(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        if (format == Format.H24) {
            return super.toString();
        }

        int hour = time.getHour();
        String ampm = (hour < 12) ? "AM" : "PM";

        if (hour == 0) hour = 12;
        else if (hour > 12) hour -= 12;

        return String.format("%d:%02d:%02d %s", hour, time.getMinute(), time.getSecond(), ampm);
    }
}

abstract class ClockHand {
    public abstract void setTime(LocalTime time);
    public abstract String toSvg();
}

class SecondHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = time.getSecond() * 6;
    }

    @Override
    public String toSvg() {
        return "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"10\" stroke=\"red\" stroke-width=\"1\" transform=\"rotate(" + angle + " 100 100)\" />";
    }
}

class MinuteHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        this.angle = (time.getMinute() * 6) + (time.getSecond() * 0.1);
    }

    @Override
    public String toSvg() {
        return "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"20\" stroke=\"black\" stroke-width=\"3\" transform=\"rotate(" + angle + " 100 100)\" />";
    }
}

class HourHand extends ClockHand {
    private double angle;

    @Override
    public void setTime(LocalTime time) {
        int hour12 = time.getHour() % 12;
        this.angle = (hour12 * 30) + (time.getMinute() * 0.5) + (time.getSecond() * (0.5 / 60.0));
    }

    @Override
    public String toSvg() {
        return "<line x1=\"100\" y1=\"100\" x2=\"100\" y2=\"40\" stroke=\"black\" stroke-width=\"5\" transform=\"rotate(" + angle + " 100 100)\" />";
    }
}