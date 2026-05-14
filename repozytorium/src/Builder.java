public static class Builder {
    private Shape shape;
    private Vec2 translateVector;
    // ... inne wektory

    public Builder(Shape shape) {
        this.shape = shape; // łapiemy naszego golasa
    }

    // A tak wygląda metoda przesuwająca!
    public Builder translate(Vec2 translationVector) {
        // 1. Zapisujemy w brzuchu wektor do przesunięcia
        this.translateVector = translationVector;

        // 2. KLUCZOWY MOMENT: Zwracamy... samego siebie!
        // Dzięki temu po tej metodzie możesz dopisać kropkę i wywołać kolejną!
        return this;
    }

    // Gdy już wywołasz wszystkie kropki, na końcu dajesz build()
    public TransformationDecorator build() {
        // Tu na sam koniec tworzymy już gotowy, "zamknięty" dekorator transformacji
        return new TransformationDecorator(shape, translateVector, scaleVector, ...);
    }
}