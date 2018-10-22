//import common.PersistentState;
//import common.PluginConf;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class ConofigTest {
//
//    File inputFile;
//
//    private Element element;
//
//    private PersistentState persistentState;
//
//    @Before
//    public void init() throws Exception {
//        this.persistentState = new PersistentState();
//        inputFile = new File("D:\\input.txt");
//        SAXBuilder saxBuilder = new SAXBuilder();
//        Document document = saxBuilder.build(inputFile);
//        this.element = document.getRootElement();
//    }
//
//    @Test
//    public void testXmlReadWrite() {
//        persistentState.set(PluginConf.V2EX_NAME, "gggg");
//        this.element = persistentState.getElement();
//    }
//
//
//    @After
//    public void write() throws Exception {
//        XMLOutputter xmlOutput = new XMLOutputter();
//        xmlOutput.setFormat(Format.getPrettyFormat());
//        xmlOutput.output(element, new FileOutputStream(inputFile));
//    }
//}
