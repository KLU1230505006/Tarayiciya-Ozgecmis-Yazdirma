import java.io.*;
import java.net.*;

public class SimpleWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1989);
        System.out.println("Sunucu 1989 numaralı portu dinliyor.");

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Yeni istemci bağlandı");

                InputStream giris = socket.getInputStream();
                BufferedReader okuyucu = new BufferedReader(new InputStreamReader(giris));

                OutputStream cikis = socket.getOutputStream();
                PrintWriter yazici = new PrintWriter(cikis, true);

                String satir;
                while (!(satir = okuyucu.readLine()).isEmpty()) {
                    System.out.println(satir);
                }

                // İstemciye basit bir HTTP yanıtı gönderiyoruz
                String httpResponse = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "\r\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            font-family: 'Roboto', sans-serif;\n" +
                        "            background: linear-gradient(135deg, #74ebd5, #ACB6E5);\n" +
                        "            margin: 0;\n" +
                        "            padding: 20px;\n" +
                        "            color: #444;\n" +
                        "        }\n" +
                        "        .anasayfa {\n" +
                        "            background-color: #ffffff;\n" +
                        "            padding: 40px;\n" +
                        "            border-radius: 15px;\n" +
                        "            box-shadow: 0px 15px 30px rgba(0,0,0,0.15);\n" +
                        "            max-width: 850px;\n" +
                        "            margin: 30px auto;\n" +
                        "        }\n" +
                        "        h1 {\n" +
                        "            color: #333;\n" +
                        "            font-size: 2.8em;\n" +
                        "            margin-bottom: 15px;\n" +
                        "            text-align: center;\n" +
                        "        }\n" +
                        "        h2 {\n" +
                        "            color: #e74c3c;\n" +
                        "            font-size: 2em;\n" +
                        "            margin-bottom: 25px;\n" +
                        "            text-align: center;\n" +
                        "        }\n" +
                        "        p {\n" +
                        "            font-size: 1.2em;\n" +
                        "            color: #555;\n" +
                        "            line-height: 1.8;\n" +
                        "        }\n" +
                        "        a {\n" +
                        "            color: #3498db;\n" +
                        "            text-decoration: none;\n" +
                        "            font-weight: bold;\n" +
                        "        }\n" +
                        "        a:hover {\n" +
                        "            color: #2980b9;\n" +
                        "            text-decoration: underline;\n" +
                        "        }\n" +
                        "        .bolumbasi {\n" +
                        "            font-size: 1.8em;\n" +
                        "            color: #3498db;\n" +
                        "            margin-top: 40px;\n" +
                        "            margin-bottom: 20px;\n" +
                        "        }\n" +
                        "        .bolum {\n" +
                        "            background-color: #f4f6f7;\n" +
                        "            padding: 25px;\n" +
                        "            border-radius: 12px;\n" +
                        "            margin-bottom: 25px;\n" +
                        "            box-shadow: 0px 7px 15px rgba(0,0,0,0.1);\n" +
                        "        }\n" +
                        "        .icon {\n" +
                        "            margin-right: 10px;\n" +
                        "            color: #e74c3c;\n" +
                        "        }\n" +
                        "        @media (max-width: 768px) {\n" +
                        "            .anasayfa {\n" +
                        "                padding: 30px;\n" +
                        "            }\n" +
                        "            h1 {\n" +
                        "                font-size: 2.2em;\n" +
                        "            }\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class='anasayfa'>\n" +
                        "        <h1>Ad Soyad: Omer Abali</h1>\n" +
                        "        <h2 style='color:#e74c3c;'>Ogrenci Numarasi: 1230505006</h2>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><i class='fas fa-envelope icon'></i>Email: <a href='mailto:omerabali09@gmail.com'>omerabali09@gmail.com</a></p>\n" +
                        "            <p><i class='fas fa-phone-alt icon'></i>Telefon: <span style='color: #16a085;'>05537151429</span></p>\n" +
                        "            <p><i class='fas fa-calendar-alt icon'></i>Yas: <strong style='color: #8e44ad;'>21</strong></p>\n" +
                        "            <p><i class='fas fa-book icon'></i>Bolum: <span style='color: #d35400;'>Yazilim Muhendisligi</span></p>\n" +
                        "        </div>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><i class='fab fa-github icon'></i>GitHub: <a href='https://github.com/KLU1230505006' target='_blank'>https://github.com/KLU1230505006</a></p>\n" +
                        "            <p><i class='fab fa-linkedin icon'></i>LinkedIn: <a href='https://github.com/omerabali' target='_blank'>https://github.com/omerabali</a></p>\n" +
                        "        </div>\n" +
                        "        <p class='bolumbasi'>Yetenekler</p>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><span style='color: #27ae60;'>HTML, CSS, Python, Java, C, C++</span></p>\n" +
                        "        </div>\n" +
                        "        <p class='bolumbasi'>Deneyimler</p>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><strong>Unvan:</strong> Yazilim Muhendisi</p>\n" +
                        "            <p><strong>Sirket:</strong> ABC TECH</p>\n" +
                        "            <p><strong>Baslangic Tarihi:</strong> Haziran 2021</p>\n" +
                        "            <p><strong>Bitis Tarihi:</strong> Devam Ediyor</p>\n" +
                        "        </div>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><strong>Unvan:</strong> Web Gelistirici</p>\n" +
                        "            <p><strong>Sirket:</strong> Xyz Cozumleri</p>\n" +
                        "            <p><strong>Baslangic Tarihi:</strong> Ocak 2021</p>\n" +
                        "            <p><strong>Bitis Tarihi:</strong> Mayis 2022</p>\n" +
                        "        </div>\n" +
                        "        <div class='bolum'>\n" +
                        "            <p><strong>Unvan:</strong> Stajyer</p>\n" +
                        "            <p><strong>Sirket:</strong> Teknoloji Inovasyonlari</p>\n" +
                        "            <p><strong>Baslangic Tarihi:</strong> Haziran 2020</p>\n" +
                        "            <p><strong>Bitis Tarihi:</strong> Aralik 2020</p>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>";

                yazici.println(httpResponse);
            }
        }
    }
}
