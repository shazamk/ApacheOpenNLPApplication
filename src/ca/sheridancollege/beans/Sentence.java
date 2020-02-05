package ca.sheridancollege.beans;

import java.util.List;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity	
public class Sentence {
	private String text="";
	private List<String> entities;
	

}
