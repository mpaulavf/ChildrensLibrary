package businessLogic;

//creditos a un compa de los andes por las listas

import data.Book;
import java.util.Random;




public class MockupGenerator {
    final static String[] titulos = {"Las Acacias","Los Robles","Los Abedules","Los Arbustos","Los Lirios","Los Helechos","Los Pinos","Los Manglares","Las Yucas","La Estrella","El Grande","El Gozo","Los Gozos","La Melodía","Harmonía","La Alegría","Perseverancia","Las Aguas","Las Nueces","La Nuez Dulce","El Loco","El Mago","La Sacerdotisa","La Emperatriz","El Emperador","El Hierofante","Los Enamorados","El Carro","Justicia","El Ermitaño","La Rueda de la Fortuna","Fuerza","El Ahorcado","Muerte","Templanza","El Diablo","La Torre","La Estrella","La Luna","El Sol","El Juicio","EL MUNDO","El Sabueso","El Loro","El Canario","Las Flores","Banderas","Banderines","Bloques","La Perseverancia","Holzbau","The Deliverance","La Entreganza","The March","La Marcha","The Stand","The Black Knight","Los Aldeanos","Los Sapos","La Golosa","El Goloso","El Coloso","The Colossus","The Titan","The Vagrant","T-Pose Wario","The Bulwark","La máquina","The Machine","El Dragón","The Dragon","The Wyrm","The Drake","The Wyvern","The Imp","El Diablito","El Milenio","Truth","La Verdad","El Dulce","Las Eugenias","El Bonsai","Las Venus","The Piranhas","The Warriors","Amón","Ra","Thoth","Mut","Isis","Osiris","Horus","Bastet","Nejbet","Ra","Obelisco","La Aventura","Los Pastores","El Valle","Los Zagalillos","El Tamborilero","El Saxofón","La Rana","El Sapito","El Sapote","El Esférico","El Bloque","El Asociado","El Negocio"};
    final static String[] apellidos = {"Pinson","Jimenez","Bravo","García","Daza","Joestar","Kujo","Higashikata","Giovanna","Brando","Polnareff","Kakyoin","Avdol","Zeppeli","Faz","Pinson","Pinson","Peña","Cuevas","Gomez","Gomisio","Hidróxidos","Celis","Melo","Montoya","Von Stroheim","Straßmann","Sarmiento","Arias","Volúmenes","Botero","Fraser","Triana","Trian","Cuellar","Agudelo","Cardona","Cardozo","Cardoso","Castaño","Cifuentes","Colina","López","Correa","Cortés","Sánchez","Duque","Uribe","Vélez","Echeverry","Durant","Silva","James","Jordan","DeRozan","Cuck","Looney","Quintero","Babativa","Aparisio","Fernandez","Rodriguez","Martinez","Hernandez","Perez","Jerez","Gonzalez","Jimenez","el Sapo","Iangovicc","Ehlrich","Green","Rodman","Brownlee","Griffin","King","Crawford","Morris","Miller","Hurtado","Robado","Hoyos","Huecos","Casas","Corredor","Trotador","Miranda","Molina","Nieto","Sobrino","Olarte","Patiño","Nijimura","Ramos","Biermann","Valencia","Cossio","Fugo","Vega","Zuluaga","el Chorizo","Trujillo","Trujo","Crotolamo","Tiro","Permatrago","Timulo","Crotosobo","Obo","Padalustro","Padanguyo","Padalamo","Recibo","Monto","E.O. Speedwagon","Speedwagon","Ferrans","Karmazina","Kammer","Schiffers","Padilla","Bruce","Aldana","Lee","Bamba","Onfroy","Mateos"};
    final static String[] nombres = {"Maxwell","Flexwell","Kingwell","Armando","Mateo","Jahteo","Jahseh","Gekyume","Fermín","Ferbín","Fermán","Ferbán","Fermón","Ferbón","Fernando","Fermando","Big","Bic","Binc","Tomas","Tomías","Tobías","Golías","Alfredo","Jan","Jank","Jang","Fals","Montías","Nicolas","Edgar","Andres","Brendan","Brandon","Byron","Bruce","Birley","Broydon","Brayan","Birón","Anderßon","Felipe","Vincente","Joel","Jairo","Eduardo","Efraín","Mario","Luigi","Wario","Waluigi","Iván","Germán","David","Boris","Kolya","Anatoli","Vadym","Mishail","Vladimir","Pyotr","Igor","Sergey","Sergei","Anton","Alexei","Pietro","Biebro","Victor","ßictor","Steve","Sbeve","Peter","Beter","Fermeme","Pepe","Jerome","Gerome","Da'Quan","DeShawn","Dennis","DeAndre","Marquis","Terrel","Darnell","Tyrone","Malik","Trevon","Omar","Demar","Dominique","Demetrius","Reginald","Jamal","Maurice","Mauricio","Jalen","Darius","Xavier","Javier","Damian","Terrance","Terrence","Andre","Darryl","Jesse","LeBron","Shaquille","Shaq","Kobe","Jonathan","Joseph","Jotaro","Josuke","Giorno","Giovanni","DIO","Dio","William","Robert","Smokey","Caesar","César","Wamuu","Esidisi","Kars","Santvento","Wilhelm","Muhammed","Mohammed","Ricardo","Jean Pierre","Jürgen","Pier Luigi","Hol","Dan","Daniel","Okuyasu","Koichi","Yoshikage","Tony","Danny","Iggy","Risotto","Bruno","Leone","Narancia","Panacotta","Guido","Irina","Erina","Elizabeth","Susie Q.","Holly","Enyaba","Claudia","Nena","Trish","Peach","Daisy","Zelda","Shiek","Samus","Rosalina","Palutena","Corrin","Lucina","Robin","Isabelle","Canela","Hana","Hannah","Mei","Angela","Ashe","Brigitte","Amelie","Ana","Lena","Nami","Morgana","Claudia","Claudia","Daniela","María","Camila","Rubby","Alicia","Beatriz","Elsa","Laura","Marta","Martina","Sofía","Valentina","Antonia","Rafaela","Antonella","Emilia","Catalina","Fernanda","Lucía","Paula","Paola","Sara","Carla","Karla","Julia","Juliana","Isabela","Abigail","Aurora","Olivia","Liliana","Tatiana","Diana","Adriana","Eliana","Natalia","Andrea","Ana María","Constanza","Marysol","Marisol","Pilar","Maria del Pilar","Maria Nelsy","Trinidad","Maria Trinidad","Margarita","Olga","Diana","Patricia","Mónica","Lorena","Alexandra","Ximena","Kelley","Carolina","Marcela","Franci","Gloria","Ingrid","Esperanza","Consuelo","Lina","Yolanda","Teresa","Nancy","Greta","Fabiola","Clemencia","Bernarda","Gladys","Briceida","Blanca","Mercedes","Rosa","Veronica","Gabriela","Luisa","Mariana","Susana","Isabela","Manuela","Yvonne","Ivana","Soledad","Gertrudis"};
    final static String[] generos = {"Cuento", "Ilsutrado", "Ficción", "Romántico", "Comedia", "Fábula", "Educación", "Comic"};

    Random ran = new Random();

    Book generateBook (){
        String author = nombres[ran.nextInt(nombres.length)] + apellidos[ran.nextInt(apellidos.length)];
        String name = titulos[ran.nextInt(titulos.length)];
        String code =  String.format("%03d",ran.nextInt(100)) + "." + String.format("%03d",ran.nextInt(100));
        String genre = generos[ran.nextInt(generos.length)];

        return Book(name, code, author);
    }



}
