package behavioral._28template;

class Chess extends Game {
    @Override
    void initialize() {
        System.out.println("Chess Game Initialized! Start playing.");
    }
    @Override
    void start() {
        System.out.println("Game Started. Welcome to in the chess game!");
    }
    @Override
    void end() {
        System.out.println("Game Finished!");
    }
}

class Soccer extends Game {

    @Override
    void initialize() {
        System.out.println("Soccer Game Initialized! Start playing.");
    }

    @Override
    void start() {
        System.out.println("Game Started. Welcome to in the Soccer game!");
    }

    @Override
    void end() {
        System.out.println("Game Finished!");
    }
}
