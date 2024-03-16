public class DuyetCayNhiPhan {
    public static void main(String[] args) {
        node node7 = new node(7);
        node node5 = new node(5);
        node node12 = new node(12);
        node7.left = node5;
        node7.right = node12;
        node node3 = new node(3);
        node node4 = new node(4);
        node node1 = new node(1);
        node3.left = node1;
        node3.right = node4;
        node node6 = new node(6);
        node5.left = node3;
        node5.right = node6;
        node node9 = new node(9);
        node node15 = new node(15);
        node12.left = node9;
        node12.right = node15;
        node node8 = new node(8);
        node node10 = new node(10);
        node9.left = node8;
        node9.right = node10;
        node node13 = new node(13);
        node node17 = new node(17);
        node15.left = node13;
        node15.right = node17;
        node T = node7;
        Tree cay = new Tree();
        cay.Read(T);
        System.out.println("So nut tren cay la: " + cay.DemNut(T));
        System.out.println("La tren cay la: " + cay.DemLa(T));
        System.out.println("So bac co tren cay la: " + cay.bac(T));
    }
}
