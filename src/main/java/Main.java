public class Main {

    public static void main(String[] args) {
        GroupAdmin usb = new GroupAdmin();
        GroupAdmin usb1 = new GroupAdmin();
        usb.append("hello");
        usb1.append("my");

        ConcreteMember mem = new ConcreteMember();
        ConcreteMember mem1 = new ConcreteMember();
        usb.register(mem);
        System.out.println(usb);
        usb.register(mem);
        System.out.println(usb);
        System.out.println("mem:  " + mem);
        usb1.register(mem1);
        System.out.println("mem1:  " + mem1);
        System.out.println(usb1);
        usb.register(mem1);
        System.out.println(usb);
        System.out.println("mem1:  " + mem1);
        usb.unregister(mem1);
        usb.insert(2, "y b");

        System.out.println("mem1:  " + mem1);
        System.out.println(usb);

        usb.undo();

        System.out.println(usb);


//        usb.insert(2, "eat");
//        System.out.println(usb);
    }
}
