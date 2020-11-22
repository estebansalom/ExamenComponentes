package com.componentes.examen.service;

import java.io.File;
import java.util.List;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.springframework.stereotype.Service;

import com.componentes.examen.domain.Task;
import com.componentes.examen.domain.Workshop;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Override
	public File generateDocument(Workshop wkp, List<Task> tasks) {
		WordprocessingMLPackage wordPackage;
		try {
			wordPackage = WordprocessingMLPackage.createPackage();
			MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
			mainDocumentPart.addStyledParagraphOfText("Title", wkp.getName());
			mainDocumentPart.addParagraphOfText(wkp.getAuthor());
			for (Task t : tasks) {
				mainDocumentPart.addParagraphOfText("");
				mainDocumentPart.addParagraphOfText(" - " + t.getName());
				mainDocumentPart.addParagraphOfText(t.getLabel());
				mainDocumentPart.addParagraphOfText(t.getTime());
				mainDocumentPart.addParagraphOfText("");
			}
			File exportFile = new File(wkp.getName() + ".docx");
			try {
				wordPackage.save(exportFile);
				return exportFile;
			} catch (Docx4JException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
