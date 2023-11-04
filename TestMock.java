public class TestMock {
    public static void main(String[] args) {
        MockModel game = new MockModel();
        ViewControl board = new ViewControl(game, 5, "I check number of times you press these buttons!");
    }
}
