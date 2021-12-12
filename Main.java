import java.util.Scanner;
public class Main {

    public static void main(String args[]) {
        System.out.println("Select\n1:- compression\n2:- decompression");
        System.out.print(">> ");
        Scanner input = new Scanner(System.in);
        int sel = input.nextInt();
        Compressor lz78 = new Compressor();
        switch (sel) {
            case 1: {
                System.out.println("Enter Text");
                System.out.print(">> ");
                String str = input.next();
                
                CompressedUnit b = lz78.compress(str);
                for (Tag t : b.getTags()) {
                    System.out.println(t);
                }
                System.out.println(str);
                
                
               // System.out.println(b.getTags().size());
              //  System.out.println(str.length());
                System.out.println("compressed size = "+b.getCompresionSize()+" bits");
                System.out.println("original size =  "+str.length() * 8+" bits");
               // System.out.println(b.getTagSize());
                break;
            }
            case 2: {
                CompressedUnit b=new CompressedUnit();
                System.out.println("Enter Tags");
                while(true)
                {
                    int poss=input.nextInt();
                    if(poss==-1)
                        break;
                    char nextSymbol = input.next().charAt(0);
                    b.addTag(new Tag(poss, nextSymbol));
                }
                 System.out.println(lz78.deCompress(b));
            }
        }
    }
}

