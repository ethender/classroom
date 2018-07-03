package org.hawks.cr.service;

import java.util.*;
import org.hawks.cr.models.Notes;

public interface NotesMaterial {

	
	public Notes createNotes(Notes notes);
	
	public Notes updateNotes(Notes notes);
	
	public Notes readNote(String ref);
	
	public List<Notes> readNotesThroughUser(String user);
	
	public List<Notes> readNotesThroughUserAndClass(String user, String classRef);
	
	public List<Notes> readNotesThroughUserAndLec(String user, String lecRef);
	
	public Notes deleteNote(Notes note);
}
