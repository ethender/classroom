package org.hawks.cr.service;

import org.hawks.cr.models.Material;
import java.util.*;

public interface MaterialService {
	
	public Material createMaterial(Material material);
	
	public Material updateMaterial(Material material);
	
	public Material readMaterialThroughRef(String ref);
	
	public List<Material> readMaterialThroughLecRef(String lecRef);
	
	public List<Material> readMaterialThroughClassRef(String classRef);
	
	public Material deleteMaterial(Material mat);
	
}
