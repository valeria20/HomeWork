import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import static org.testng.Assert.assertEquals;

public class DefineTriangleTest {
    public static final String POSITIVE = "positive";
    public static final String NEGATIVE = "negative";
    public static final String EXPECTED = "expected";
    public static final String SIDE_A = "side_a";
    public static final String SIDE_B = "side_b";
    public static final String SIDE_C = "side_c";

    @DataProvider(name = "Data for triangle with different sides")
    public Object[][] triangleWithDifferentSide() throws Exception {
        File inputFile = new File("D:\\PositiveDataForTriangleWithDifferentSides.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(POSITIVE);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Data for triangle with different sides")
    public void positiveTestTriangleWithDifferentSides(String expected, double a, double b, double c) {
        DefineTriangle triangle = new DefineTriangle();
        String type=" ";
        type = triangle.differentSides(a, b, c);
        assertEquals(expected, type);
    }

    @DataProvider(name = "Data for isosceles triangle")
    public Object[][] isoscelesTriangle() throws Exception {
        File inputFile = new File("D:\\PositiveDataForIsoscelesTriangle.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(POSITIVE);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Data for isosceles triangle")
    public void positiveTestForIsoscelesTriangle(String expected, double a, double b, double c) {
        DefineTriangle triangle = new DefineTriangle();
        String type=" ";
        type = triangle.isoscelesTriangle(a, b, c);
        assertEquals(expected, type);
    }

    @DataProvider(name = "Data for equilateral triangle")
    public Object[][] equilateralTriangle() throws Exception {
        File inputFile = new File("D:\\PositiveDataForEquilateralTriangle.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(POSITIVE);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Data for equilateral triangle")
    public void positiveTestEquilateralTriangle(String expected, double a, double b, double c) {
        DefineTriangle triangle = new DefineTriangle();
        String type=" ";
        type = triangle.equilateralTriangle(a, b, c);
        assertEquals(expected, type);
    }

    @DataProvider(name = "Invalid data")
    public Object[][] invalid() throws Exception {
        File inputFile = new File("D:\\InvalidData.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        NodeList nodeList = document.getElementsByTagName(NEGATIVE);
        Object[][] result = new Object[nodeList.getLength()][];
        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    map.getNamedItem(EXPECTED).getNodeValue(),
                    Double.parseDouble(map.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(map.getNamedItem(SIDE_C).getNodeValue())
            };
        }
        return result;
    }

    @Test(dataProvider = "Invalid data")
    public void negativeTestTriangle(String expected, double a, double b, double c) {
        DefineTriangle triangle = new DefineTriangle();
        String type=" ";
        type = triangle.checkForIvalidVariables(a, b, c);
        assertEquals(expected, type);
    }
}

