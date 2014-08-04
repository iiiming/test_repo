package gov.va.escreening.service.export;

import java.util.Map;

public interface CellValueExtractor {

	String apply(String tbiXportKeyName, Map<String, String> varsMap);

}
