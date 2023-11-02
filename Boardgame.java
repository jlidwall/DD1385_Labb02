interface Boardgame {
    boolean move(int x, int y);
    String getStatus(int x, int y);
    String getMessage();
}