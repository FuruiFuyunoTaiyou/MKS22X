public class Driver{
    public static void main(String[]args){
        Maze f;
        f = new Maze("data1.dat");
        f.setAnimate(true);
        f.solve();
        System.out.println(f);
    }
}
