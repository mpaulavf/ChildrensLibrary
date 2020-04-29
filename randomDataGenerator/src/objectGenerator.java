/*
EL SIGUIENTE PROGRAMA SE USA PARA GENERAR LOS DATOS ALEATORIOS DE PRUEBA EN LA APLICACION DE ANDROID. POR FACILIDAD SE
SE HA DEJADO PARA USAR COMO UN JAVA POR CONSOLA, PARA ASÍ PODER IMPORTAR DESPUÉS LOS ARCHIVOS CSV A LA APP.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class objectGenerator {

    final static String[] userNombres = {"Maria","Carmen","Josefa","Isabel","Francisca","Antonia","Ana","Pilar","Lucia",
            "Cristina","Laura","Juana","Elena","Marta","Manuela","Raquel","Angeles","Mercedes","Irene","Teresa","Beatriz",
            "Paula","Angela","Julia","Rocio","Amparo","Alicia","Andrea","Antonio","Jose","Francisco","Juan","Manuel",
            "Pedro","Jesus","Angel","Miguel","Javier","David","Carlos","Luis","Alejandro","Rafael","Daniel","Pablo",
            "Joaquin","Sergio","Fernando","Juan","Carlos","Andres","Ramon","Raul","Alberto","Enrique","Alvaro", "Vicente",
            "Emilio","Diego","Julian","Jorge","Alfonso","Adrian","Ruben","Santiago","Ivan","Pascual","Mario"};

    final static String[] userApellidos = {"Garcia","Martinez","Lopez","Sanchez","Gonzalez","Gomez","Fernandez","Moreno",
            "Jimenez","Perez","Rodriguez","Navarro","Ruiz","Diaz","Serrano","Hernandez","Muñoz","Saez","Romero","Rubio",
            "Alfaro","Molina","Lozano","Castillo","Picazo","Ortega","Morcillo","Cano","Marin","Cuenca","Garrido","Torres",
            "Corcoles","Gil","Ortiz","Calero","Valero","Cebrian","Rodenas","Alarcon","Blazquez","Nuñez","Pardo","Moya","Tovar",
            "Requena","Arenas","Ballesteros","Collado","Ramirez"};

    final static String[] generos = {"Cuento", "Ilsutrado", "Ficción", "Romántico", "Comedia", "Fábula", "Educación", "Comic"};

    final static String[] titulos = {"Las Acacias","Los Robles","Los Abedules","Los Arbustos","Los Lirios","Los Helechos","Los Pinos","Los Manglares","Las Yucas","La Estrella","El Grande","El Gozo","Los Gozos","La Melodía","Harmonía","La Alegría","Perseverancia","Las Aguas","Las Nueces","La Nuez Dulce","El Loco","El Mago","La Sacerdotisa","La Emperatriz","El Emperador","El Hierofante","Los Enamorados","El Carro","Justicia","El Ermitaño","La Rueda de la Fortuna","Fuerza","El Ahorcado","Muerte","Templanza","El Diablo","La Torre","La Estrella","La Luna","El Sol","El Juicio","EL MUNDO","El Sabueso","El Loro","El Canario","Las Flores","Banderas","Banderines","Bloques","La Perseverancia","Holzbau","The Deliverance","La Entreganza","The March","La Marcha","The Stand","The Black Knight","Los Aldeanos","Los Sapos","La Golosa","El Goloso","El Coloso","The Colossus","The Titan","The Vagrant","T-Pose Wario","The Bulwark","La máquina","The Machine","El Dragón","The Dragon","The Wyrm","The Drake","The Wyvern","The Imp","El Diablito","El Milenio","Truth","La Verdad","El Dulce","Las Eugenias","El Bonsai","Las Venus","The Piranhas","The Warriors","Amón","Ra","Thoth","Mut","Isis","Osiris","Horus","Bastet","Nejbet","Ra","Obelisco","La Aventura","Los Pastores","El Valle","Los Zagalillos","El Tamborilero","El Saxofón","La Rana","El Sapito","El Sapote","El Esférico","El Bloque","El Asociado","El Negocio"};

    static Random ran = new Random();

    public static void main(String[] args){
        int n = 0;

        System.out.println("Indique cuantos datos va a crear");

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        generateBookFile(n);
        generateUserFile(n);

    }



    public static void generateBookFile(int n){
        String title, author, code, genre;

        String path = "data/listaLibros_x" + n + ".csv";

        File listaLibros = new File(path);

        try {
            PrintWriter peewee = new PrintWriter(listaLibros);


            for (int i=0; i<n; i++) {
                title = titulos[ran.nextInt(titulos.length)];
                author = userNombres[ran.nextInt(userNombres.length)] + " "+  userApellidos[ran.nextInt(userApellidos.length)];
                code = String.format("%06d", i);
                genre = generos[ran.nextInt(generos.length)];

                peewee.println(title + "," + author + "," + code + "," + genre);

            }
            peewee.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateUserFile(int n){
        String name, surname, nickname, password;

        String path = "data/listaUsuarios_x" + n + ".csv";

        File listaLibros = new File(path);

        try {
            PrintWriter peewee = new PrintWriter(listaLibros);

        Boolean isWorker;
        for (int i=0; i<n; i++) {
            name = userNombres[ran.nextInt(userNombres.length)];
            surname = userApellidos[ran.nextInt(userApellidos.length)];
            nickname = generateNickname(name, surname);
            password = generatePassword();
            isWorker = generateBoolean(ran.nextDouble());

            peewee.println(name + "," + surname + "," + nickname + "," + password + "," + String.valueOf(isWorker));
        }

            peewee.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String generateNickname(String name, String surname){
        String nickname;
        nickname = name.substring(0,2) + surname.substring(0,2);
        return nickname;
    }

    public static String generatePassword(){
        String password="";
        for(int i=0; i<8; i++) {
            Integer temp = ((int)Math.floor(Math.random()*5+1));
            password+=temp.toString();
        }
        return password;
    }

    public static  Boolean generateBoolean(double n){   //La razón de dejar tan solo los datos mayores a 0.9 es para sesgar la probabilidad de que solo haya un 10% de trabajadores en la muestra.
        if (n>=0.9) { return true; }
        return false;
    }


}
