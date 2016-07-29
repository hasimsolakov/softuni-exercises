package Main;

import java.util.Scanner;

public class Problem20_URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String [] splittedByProtocolDelimeter = url.split("://");
        String serverResourcePart;
        String protocol = "";
        if (splittedByProtocolDelimeter.length > 1){
            protocol = splittedByProtocolDelimeter[0];
            serverResourcePart = splittedByProtocolDelimeter[1];
        }
        else{
            serverResourcePart = url;
        }

        String server;
        String resource = "";
        String [] splittedByServerDelimeter = serverResourcePart.split("/");
        if (splittedByServerDelimeter.length > 1){
            server = splittedByServerDelimeter[0];
            resource = serverResourcePart.replace(server + "/","");
        }
        else {
            server = serverResourcePart;
        }

        System.out.println("[protocol] = \"" + protocol + "\"");
        System.out.println("[server] = \"" + server + "\"");
        System.out.println("[resource] = \"" + resource + "\"");
    }
}

