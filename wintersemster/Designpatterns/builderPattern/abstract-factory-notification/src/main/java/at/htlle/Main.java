package at.htlle;

import at.htlle.factory.EmailFactory;
import at.htlle.factory.NotificationFactory;
import at.htlle.factory.SmsFactory;
import at.htlle.notifier.Notifier;
import at.htlle.formatter.MessageFormatter;

public class Main {
    public static void main(String[] args) {
        // TODO: Wählen Sie hier eine konkrete Factory, z. B. new EmailFactory()
        NotificationFactory factory = new EmailFactory();

        // TODO: Erstellen Sie einen Notifier und einen Formatter über die Factory
        Notifier notifier = factory.createNotifier();
        MessageFormatter formatter = factory.createFormatter();

        // TODO: Formatieren Sie eine Nachricht und senden Sie sie
        String message = "Hallo!";
        notifier.send("Empfänger", message);

        NotificationFactory factory2 = new SmsFactory();
        Notifier notifier2 = factory2.createNotifier();
        MessageFormatter formatter2 = factory2.createFormatter();
        String message2 = "Hallo!";
        notifier2.send("Empfänger", message2);
    }
}
