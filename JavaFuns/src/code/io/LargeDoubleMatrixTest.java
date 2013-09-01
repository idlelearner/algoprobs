//package code.io;
//
//import java.io.IOException;
//
//public class LargeDoubleMatrixTest {
//    @Test
//    public void getSetMatrix() throws IOException {
//        long start = System.nanoTime();
//        final long used0 = usedMemory();
//        LargeDoubleMatrix matrix = new LargeDoubleMatrix("ldm.test", 1000 * 1000, 1000 * 1000);
//        for (int i = 0; i < matrix.width(); i++)
//            matrix.set(i, i, i);
//        for (int i = 0; i < matrix.width(); i++)
//            assertEquals(i, matrix.get(i, i), 0.0);
//        long time = System.nanoTime() - start;
//        final long used = usedMemory() - used0;
//        if (used == 0)
//            System.err.println("You need to use -XX:-UseTLAB to see small changes in memory usage.");
//        System.out.printf("Setting the diagonal took %,d ms, Heap used is %,d KB%n", time / 1000 / 1000, used / 1024);
//        matrix.close();
//    }
//
//    private long usedMemory() {
//        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//    }
//}