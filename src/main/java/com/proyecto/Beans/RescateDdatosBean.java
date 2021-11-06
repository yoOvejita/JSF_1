package com.proyecto.Beans;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.proyecto.Entity.Country;
import com.proyecto.Entity.ObjetoMaestro;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author rusok-pro
 */
@Named(value = "rescateDdatosBean")
@Dependent
public class RescateDdatosBean {
    private List<Country> paises;
    /**
     * Creates a new instance of RescateDdatosBean
     */
    public RescateDdatosBean() {
        //paraCertificados();//Usable solo en caso extremo de no reconocerse el certificado
        Probandolo();
    }

    public List<Country> getPaises() {
        return paises;
    }

    public void setPaises(List<Country> paises) {
        this.paises = paises;
    }
    
    private void Probandolo() {
        String https_url = "https://api.covid19api.com/summary";
        URL url;
        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            //certificado
            print_https_cert(con);
            //el contenido
            print_content(con);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void print_https_cert(HttpsURLConnection con) {
        if (con != null) {
            try {
                System.out.println("Response Code : " + con.getResponseCode());
                System.out.println("Cipher Suite : " + con.getCipherSuite());
                System.out.println("\n");
                Certificate[] certs = con.getServerCertificates();
                for (Certificate cert : certs) {
                    System.out.println("Cert Type : " + cert.getType());
                    System.out.println("Cert Hash Code : " + cert.hashCode());
                    System.out.println("Cert Public Key Algorithm : "
                            + cert.getPublicKey().getAlgorithm());
                    System.out.println("Cert Public Key Format : "
                            + cert.getPublicKey().getFormat());
                    System.out.println("\n");
                }
            } catch (SSLPeerUnverifiedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void print_content(HttpsURLConnection con) {
        if (con != null) {
            try {
                System.out.println("****** Content of the URL ********");
                BufferedReader br
                        = new BufferedReader(
                                new InputStreamReader(con.getInputStream()));
                String input;
                while ((input = br.readLine()) != null) {
                    System.out.println(input);
                    ponerValores(con, input);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ponerValores(HttpsURLConnection con, String inline) {
        try {
            ObjetoMaestro obj = new Gson().fromJson(inline, new TypeToken<ObjetoMaestro>(){}.getType());
            paises = new LinkedList<>();
            paises = obj.getCountries();
            for (Country c : paises) {
                System.out.println(c.Country);
            }
        } catch (JsonSyntaxException eee) {
            eee.printStackTrace();
        }
    }

    private void paraCertificados() {
        try {
            // Reparacion de certificado issue
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            // FIN Reparacion de certificado issue
        } catch (KeyManagementException | NoSuchAlgorithmException ee) {
            System.out.println("NO FUNCIONA");
        }
    }
}
