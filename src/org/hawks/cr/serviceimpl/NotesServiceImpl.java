package org.hawks.cr.serviceimpl;

import java.util.List;

import org.hawks.cr.models.Notes;
import org.hawks.cr.service.NotesService;
import org.springframework.stereotype.Service;

@Service("notesservice")
public class NotesServiceImpl implements NotesService{

	@Override
	public Notes createNotes(Notes notes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notes updateNotes(Notes notes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notes readNote(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> readNotesThroughUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> readNotesThroughUserAndClass(String user, String classRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> readNotesThroughUserAndLec(String user, String lecRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notes deleteNote(Notes note) {
		// TODO Auto-generated method stub
		return null;
	}

}
