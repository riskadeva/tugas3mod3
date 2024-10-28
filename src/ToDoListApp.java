import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aplikasi Daftar Tugas Sederhana.
 * Aplikasi ini memungkinkan pengguna untuk menambah, menghapus, dan melihat daftar tugas.
 */
public class ToDoListApp {
    private static final int ADD_TASK = 1;
    private static final int REMOVE_TASK = 2;
    private static final int VIEW_TASKS = 3;
    private static final int EXIT = 4;

    /**
     * Metode utama untuk menjalankan aplikasi daftar tugas.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            choice = displayMenu(scanner);
            handleUserChoice(choice, toDoList, scanner);
        } while (choice != EXIT);

        scanner.close();
    }

    /**
     * Menampilkan menu utama dan mengambil pilihan pengguna.
     *
     * @param scanner Scanner untuk mengambil input pengguna
     * @return pilihan pengguna
     */
    private static int displayMenu(Scanner scanner) {
        System.out.println("\n--- Daftar Tugas Sederhana ---");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Hapus Tugas");
        System.out.println("3. Lihat Daftar Tugas");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
        return scanner.nextInt();
    }

    /**
     * Menghandle pilihan yang dipilih oleh pengguna.
     *
     * @param choice     pilihan pengguna
     * @param toDoList   daftar tugas
     * @param scanner    Scanner untuk mengambil input pengguna
     */
    private static void handleUserChoice(int choice, ArrayList<String> toDoList, Scanner scanner) {
        scanner.nextLine();  // Membersihkan buffer input

        switch (choice) {
            case ADD_TASK:
                addTask(toDoList, scanner);
                break;
            case REMOVE_TASK:
                removeTask(toDoList, scanner);
                break;
            case VIEW_TASKS:
                viewTasks(toDoList);
                break;
            case EXIT:
                System.out.println("Terima kasih! Sampai jumpa.");
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan coba lagi.");
                break;
        }
    }

    /**
     * Menambahkan tugas baru ke daftar tugas.
     *
     * @param toDoList daftar tugas
     * @param scanner  Scanner untuk mengambil input pengguna
     */
    private static void addTask(ArrayList<String> toDoList, Scanner scanner) {
        System.out.print("Masukkan tugas yang ingin ditambahkan: ");
        String task = scanner.nextLine();
        toDoList.add(task);
        System.out.println("Tugas berhasil ditambahkan!");
    }

    /**
     * Menghapus tugas dari daftar berdasarkan nomor tugas.
     *
     * @param toDoList daftar tugas
     * @param scanner  Scanner untuk mengambil input pengguna
     */
    private static void removeTask(ArrayList<String> toDoList, Scanner scanner) {
        System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
        int taskNumber = scanner.nextInt();
        if (isValidTaskNumber(taskNumber, toDoList.size())) {
            toDoList.remove(taskNumber - 1);
            System.out.println("Tugas berhasil dihapus!");
        } else {
            System.out.println("Nomor tugas tidak valid.");
        }
    }

    /**
     * Menampilkan semua tugas yang ada dalam daftar.
     *
     * @param toDoList daftar tugas
     */
    private static void viewTasks(ArrayList<String> toDoList) {
        System.out.println("\n--- Daftar Tugas ---");
        if (toDoList.isEmpty()) {
            System.out.println("Tidak ada tugas.");
        } else {
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    /**
     * Memeriksa apakah nomor tugas yang diberikan valid.
     *
     * @param taskNumber nomor tugas yang akan diperiksa
     * @param size       ukuran daftar tugas
     * @return true jika nomor tugas valid, false jika tidak
     */
    private static boolean isValidTaskNumber(int taskNumber, int size) {
        return taskNumber > 0 && taskNumber <= size;
    }
}
