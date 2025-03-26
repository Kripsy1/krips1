package cz.veletova.pojisteni;

import java.util.Scanner;
import cz.veletova.pojisteni.models.Pojistenec;
import cz.veletova.pojisteni.service.PojistenecService;

public class PojisteniApp {
    private static final PojistenecService pojistenecService = new PojistenecService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n📋 Možnosti:");
            System.out.println("1️⃣ Přidat pojištěnce");
            System.out.println("2️⃣ Zobrazit pojištěnce");
            System.out.println("3️⃣ Upravit pojištěnce");
            System.out.println("4️⃣ Odstranit pojištěnce");
            System.out.println("5️⃣ Konec");
            System.out.print("\nVyberte akci: ");

            String volba = scanner.nextLine();

            switch (volba) {
                case "1":
                    pridatPojistence();
                    break;
                case "2":
                    zobrazitPojistence();
                    break;
                case "3":
                    upravitPojistence();
                    break;
                case "4":
                    odstranitPojistence();
                    break;
                case "5":
                    System.out.println("👋 Ukončuji aplikaci...");
                    return;
                default:
                    System.out.println("❌ Neplatná volba, zkuste to znovu.");
            }
        }
    }

    private static void pridatPojistence() {
        System.out.println("\n✏ Zadejte jméno:");
        String jmeno = scanner.nextLine();
        System.out.println("✏ Zadejte příjmení:");
        String prijmeni = scanner.nextLine();
        System.out.println("📧 Zadejte email:");
        String email = scanner.nextLine();
        System.out.println("📞 Zadejte telefon:");
        String telefon = scanner.nextLine();
        System.out.println("🏡 Zadejte ulici:");
        String ulice = scanner.nextLine();
        System.out.println("🏙 Zadejte město:");
        String mesto = scanner.nextLine();
        System.out.println("📮 Zadejte PSČ:");
        String psc = scanner.nextLine();

        Pojistenec novyPojistenec = new Pojistenec(0, jmeno, prijmeni, email, telefon, ulice, mesto, psc);
        pojistenecService.pridatPojistence(novyPojistenec);
        System.out.println("✅ Pojištěnec byl přidán.");
    }

    private static void zobrazitPojistence() {
        System.out.println("\n📄 Seznam pojištěnců:");
        for (Pojistenec p : pojistenecService.getAllPojistenci()) {
            System.out.println(p);
        }
    }

    private static void upravitPojistence() {
        System.out.println("\n✏ Zadejte email pojištěnce, kterého chcete upravit:");
        String email = scanner.nextLine();

        System.out.println("✏ Zadejte nové jméno:");
        String noveJmeno = scanner.nextLine();
        System.out.println("✏ Zadejte nové příjmení:");
        String novePrijmeni = scanner.nextLine();
        System.out.println("📞 Zadejte nový telefon:");
        String novyTelefon = scanner.nextLine();
        System.out.println("🏡 Zadejte novou ulici:");
        String novaUlice = scanner.nextLine();
        System.out.println("🏙 Zadejte nové město:");
        String noveMesto = scanner.nextLine();
        System.out.println("📮 Zadejte nové PSČ:");
        String novePsc = scanner.nextLine();

        Pojistenec upraveny = new Pojistenec(0, noveJmeno, novePrijmeni, email, novyTelefon, novaUlice, noveMesto, novePsc);
        pojistenecService.updatePojistenec(upraveny);
        System.out.println("✅ Pojištěnec byl úspěšně upraven.");
    }

    private static void odstranitPojistence() {
        System.out.println("\n🗑 Zadejte email pojištěnce, kterého chcete odstranit:");
        String email = scanner.nextLine();

        pojistenecService.deletePojistenec(email);
        System.out.println("✅ Pojištěnec byl úspěšně odstraněn.");
    }
}
