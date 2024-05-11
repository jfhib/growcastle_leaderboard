/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package parser;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

// import org.telegram.telegrambots.meta.TelegramBotsApi;
// import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
// import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import parser.db.Database;
import parser.telegram.TelegramBot;

public class Main {

    public static void main(String[] args)
        throws NullPointerException, TelegramApiException, InterruptedException
    {
        TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();

        Database db = new Database("growcastle");
        db.connectEntityManagerFactory();

        TelegramBot telegramBot = new TelegramBot(db, "telegram");
        System.out.println("telegram bot token : " + telegramBot.getAPIBotToken());
        botsApplication.registerBot(telegramBot.getAPIBotToken(), telegramBot);
        System.out.println("TelegramBot successfully started!");

        telegramBot.sendMsg("connect success");
        System.out.println("msg send success!");


        Thread.currentThread().join();
        // Thread.sleep(1000);

        // Ensure this process wait forever

        try {
            botsApplication.close();
            System.out.println("disconnect Telegram");
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnectEntityManagerFactory();
        System.out.println("disconnect Database");

    }

}
