package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentCenterParameterTest {
	
	@Test
	public void testPojo() {
		DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
		documentCenterParameter.setDocumentCenterId("a");
		documentCenterParameter.setTitleEnglish("a");
		documentCenterParameter.setTitleTraditionalChinese("a");
		documentCenterParameter.setTitleSimplifiedChinese("a");
		documentCenterParameter.setDocumentStatus("a");
		documentCenterParameter.setLevel1CategoryId("a");
		documentCenterParameter.setLevel2CategoryId("a");
		documentCenterParameter.setDescriptionEnglish("a");
		documentCenterParameter.setDescriptionTraditionalChinese("a");
		documentCenterParameter.setDescriptionSimplifiedChinese("a");
		documentCenterParameter.setFile1Id("a");
		documentCenterParameter.setFile2Id("a");
		documentCenterParameter.setFile3Id("a");
		documentCenterParameter.setEffectiveDateFrom("a");
		documentCenterParameter.setEffectiveDateTo("a");
		documentCenterParameter.setCreatedDateFrom("a");
		documentCenterParameter.setCreatedDateTo("a");
		documentCenterParameter.setUpdatedDateFrom("a");
		documentCenterParameter.setUpdatedDateTo("a");
		
		assertEquals("a",documentCenterParameter.getDocumentCenterId());
		assertEquals("a",documentCenterParameter.getTitleEnglish());
		assertEquals("a",documentCenterParameter.getTitleTraditionalChinese());
		assertEquals("a",documentCenterParameter.getTitleSimplifiedChinese());
		assertEquals("a",documentCenterParameter.getDocumentStatus());
		assertEquals("a",documentCenterParameter.getLevel1CategoryId());
		assertEquals("a",documentCenterParameter.getLevel2CategoryId());
		assertEquals("a",documentCenterParameter.getDescriptionEnglish());
		assertEquals("a",documentCenterParameter.getDescriptionTraditionalChinese());
		assertEquals("a",documentCenterParameter.getDescriptionSimplifiedChinese());
		assertEquals("a",documentCenterParameter.getFile1Id());
		assertEquals("a",documentCenterParameter.getFile2Id());
		assertEquals("a",documentCenterParameter.getFile3Id());
		assertEquals("a",documentCenterParameter.getEffectiveDateFrom());
		assertEquals("a",documentCenterParameter.getEffectiveDateTo());
		assertEquals("a",documentCenterParameter.getCreatedDateFrom());
		assertEquals("a",documentCenterParameter.getCreatedDateTo());
		assertEquals("a",documentCenterParameter.getUpdatedDateFrom());
		assertEquals("a",documentCenterParameter.getUpdatedDateTo());


	}

}
