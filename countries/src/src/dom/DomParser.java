package dom;

import model.Country;
import org.w3c.dom.*;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DomParser
{
  public List<Country> parse(Document document) throws FileNotFoundException, XMLStreamException
  {
    NodeList nodeList = document.getElementsByTagName("Country");
    List<Country> Countries = new ArrayList<Country>();
    for (int i = 0; i < nodeList.getLength(); i++)
    {
      Countries.add(getCountry(nodeList.item(i)));
    }
    return Countries;
  }

  private Country getCountry(Node node)
  {
    Country country = new Country();
    Element element = (Element) node;
    NamedNodeMap nodeMap = node.getAttributes();
    if (nodeMap != null){
      for (int i = 0; i < nodeMap.getLength(); i++)
      {
        country.setId(Integer.parseInt(nodeMap.item(i).getNodeValue()));
      }
    }
    country.setCode(getTagValue("Code", element));
    country.setName(getTagValue("Name", element));
    country.setDescription(getTagValue("Description", element));
    return country;
  }

  private static String getTagValue(String tag, Element element)
  {
    NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
    Node node = nodeList.item(0);
    return node.getNodeValue();
  }
}
