package behavioral._27strategy;

class Addition implements Strategy {
    @Override
    public float calculation(float a, float b) {
        return a + b;
    }
}

class Subtraction implements Strategy {
    @Override
    public float calculation(float a, float b) {
        return a - b;
    }
}

class Multiplication implements Strategy {
    @Override
    public float calculation(float a, float b) {
        return a * b;
    }
}