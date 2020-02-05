package ca.sheridancollege.NLP;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

public class NLP {

	private List<String> tags;

	public List <String> Process(String text) throws Exception {

		tags = new ArrayList<String>();

// Initialize the tokenizer
		
		InputStream inputStreamTokenizer = new FileInputStream("C:/OpenNLP_models/en-token.bin");
		TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
		TokenizerME tokenizer = new TokenizerME(tokenModel);

// Tokenize text

		String tokens[] = tokenizer.tokenize(text);

//Load the NER-location moodel 

		InputStream inputStreamNameFinder = new FileInputStream("C:/OpenNLP_models/en-ner-location.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);

//Instantiate the NameFinderME class 

		NameFinderME nameFinder = new NameFinderME(model);

// Find the names of a location and load them into tags list

		Span nameSpans[] = nameFinder.find(tokens);

		for (Span s : nameSpans) {
			
			String[] temp=s.toString().split("\\)");
			
			tags.add(temp[1] + "  " + tokens[s.getStart()]);
		}

//----------------------------------------------------------------------------------------------------	

//Load the NER-person model 

		inputStreamNameFinder = new FileInputStream("C:/OpenNLP_models/en-ner-person.bin");

		model = new TokenNameFinderModel(inputStreamNameFinder);

//Instantiating the NameFinderME class 

		nameFinder = new NameFinderME(model);

//Finding the names of a Persons

		nameSpans = nameFinder.find(tokens);

//Find the names of persons and load them into tags list 

		for (Span s : nameSpans) {
			
			String[] temp=s.toString().split("\\)");
			tags.add(temp[1] + "  " + tokens[s.getStart()]);
		}

		return tags;

	}
}