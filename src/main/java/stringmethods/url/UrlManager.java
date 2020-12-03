package stringmethods.url;

//import org.junit.platform.commons.function.Try;

import java.util.ArrayList;
import java.util.List;

public class UrlManager {
    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;
    private List<Key> keys  = new ArrayList<Key>();

    private void stringValidator (String fName) throws IllegalArgumentException{
        if (fName == null || fName.isBlank()) {
            throw new IllegalArgumentException("Invalid url");
        }
    }



    private  String parseProtocol(String url) {
        String protocol="";
        if (url.indexOf("://") < 4) {
            throw new IllegalArgumentException("Invalid url");
        }
        protocol=url.substring(0,url.indexOf("://")).toLowerCase();
        if (!(protocol.equals("file") || protocol.equals("http") || protocol.equals("https"))) {
            throw new IllegalArgumentException("Invalid url");
        }
        return protocol;
    }

    private String parseHost(String url) {
        String host = url.toLowerCase();
        stringValidator(host);
        if (host.contains("/")) {
            host = host.substring(0,host.indexOf("/"));
        }
        if (host.contains("?")) {
            host = host.substring(0,host.indexOf("?"));
        }
        return host;
    }

    private String parsePath (String url) {
        if (url.indexOf("/")>-1) {
            return url.substring(0,(url.indexOf("?") > -1 ? url.indexOf("?") : url.length()));
        };

        return "";
    }

    private void parseQuery(String query) {
        String tempString = query;
        String aKey;
        String aValue;

        while (tempString.toLowerCase().contains("="))  {
            aKey=tempString.substring(0,tempString.indexOf("="));
            if (tempString.contains("&")) {
                aValue=tempString.substring(tempString.indexOf("=")+1,tempString.indexOf("&"));
                tempString = tempString.substring(tempString.indexOf("&")+1);
            } else {
                aValue = tempString.substring(tempString.indexOf("=")+1);
                tempString = "";
            }
            keys.add(new Key(aKey,aValue));
        }
    }

    public UrlManager(String url) {
        stringValidator(url);
        int from =0;
        String urlToCut = url.trim();
        protocol = parseProtocol(url);

        from = protocol.length()+3;
        urlToCut = urlToCut.substring(from);
        host = parseHost(urlToCut);
        if (host.contains(":")) {
            try {
                port = Integer.parseInt(host.substring(host.indexOf(":")+1));
            } catch (ArithmeticException ex) {
                throw new IllegalArgumentException ("Érvénytelen port");
            }
            from = host.length();
            host = host.substring(0, host.indexOf(":"));
            if (from < urlToCut.length() ) {
                urlToCut = urlToCut.substring(from);
            }
        }else {
//            port = null;
            from = host.length();
            if (from < urlToCut.length() ) {
                urlToCut = urlToCut.substring(from);
            }
        }
        path= parsePath(urlToCut);
        if (urlToCut.contains("?")) {
            query = urlToCut.substring(urlToCut.indexOf("?")+1);
            parseQuery(query);
        }

    }

    public boolean hasProperty(String kulcs) {
        stringValidator(kulcs);
        for (Key key: keys) {
            if (key.getKey().equals(kulcs)) {
                return true;
            }
        }
        return false;
    }

    public String getProperty(String key) {
        stringValidator(key);
        for (Key aKey : keys) {
            if (aKey.getKey().equals(key)) {
                return aKey.getValue();
            }
        }
        return null;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

}
