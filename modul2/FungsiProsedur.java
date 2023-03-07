package modul2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FungsiProsedur {
    static ArrayList<String> listBuah = new ArrayList<String>();
    static boolean isRunning = true;
    static Scanner input = new Scanner(System.in);

    static void showMenu() throws IOException {
        System.out.println("========= MENU ========");
        System.out.println("[1] Show All Buah");
        System.out.println("[2] Insert Buah");
        System.out.println("[3] Edit Buah");
        System.out.println("[4] Delete Buah");
        System.out.println("[5] Exit");
        System.out.print("PILIH MENU> ");
        int selectedMenu = input.nextInt();
        switch (selectedMenu) {
            case 1:
                showAllBuah();
                break;
            case 2:
                insertBuah();
                break;
            case 3:
                editBuah();
                break;
            case 4:
                deleteBuah();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan salah!");
        }
    }

    static void showAllBuah() {
        if (listBuah.isEmpty()) {
            System.out.println("Belum ada data");
        } else {
            // tampilkan semua buah
            for (int i = 0; i < listBuah.size(); i++) {
                System.out.println(String.format("[%d] %s", i, listBuah.get(i)));
            }
        }

    }

    static void insertBuah() throws IOException {
        System.out.print("Nama buah: ");
        String namaBuah = input.next();
        listBuah.add(namaBuah);
    }

    static void editBuah() throws IOException {
        showAllBuah();
        System.out.print("Pilih nomer buah: ");
        int indexBuah = input.nextInt();
        System.out.print("Nama Baru: ");
        String namaBaru = input.next();
        // ubah nama buah
        listBuah.set(indexBuah, namaBaru);
    }

    static void deleteBuah() throws IOException {
        showAllBuah();
        System.out.print("Pilih nomer buah: ");
        int indexBuah = input.nextInt();
        // hapus buah
        listBuah.remove(indexBuah);
    }

    public static void main(String[] args) throws IOException {
        do {
            showMenu();
        } while (isRunning);
    }
}
