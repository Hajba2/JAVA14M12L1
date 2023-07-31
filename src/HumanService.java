public class HumanService {

    GoogleRegisterService grs = new GoogleRegisterService();

    public void sendToRegistationService(Human h) {
        long begin = System.currentTimeMillis();

        //call to google api to register user
        grs.send(h);

        long end = System.currentTimeMillis();

        long requestDuration = end - begin;
        //sendRequestDuarationToAnaticService(requestDuration);
    }
}
