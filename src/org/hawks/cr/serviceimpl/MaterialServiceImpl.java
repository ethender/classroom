package org.hawks.cr.serviceimpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.hawks.cr.daoimpl.DAOImpl;
import org.hawks.cr.models.Material;
import org.hawks.cr.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service("materialservice")
@SuppressWarnings("unchecked")
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	private DAOImpl dao;
	
	
	public Material createMaterial(Material material) {
		Material result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Material> runnable = service.submit(()->{
				dao.create(material);
				return material;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public Material updateMaterial(Material material) {
		Material result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Material> runnable = service.submit(()->{
				Query query =  new Query(Criteria.where("_id").is(material.get_id()));
				Update update = new Update();
				update.set("uploadRef", material.getUploadRef());
				update.set("lastModified", org.hawks.utils.util.getDateNow());
				dao.update(query, update, Material.class);
				return material;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	public Material readMaterialThroughRef(String ref) {
		Material result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Material> runnable = service.submit(()->{
				Query query =  new Query(Criteria.where("_id").is(ref));
				return ((List<Material>)dao.readWithQuery(query, Material.class)).get(0);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	
	public List<Material> readMaterialThroughLecRef(String lecRef) {
		List<Material> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Material>> runnable = service.submit(()->{
				Query query =  new Query(Criteria.where("lecRef").is(lecRef));
				return (List<Material>)dao.readWithQuery(query, Material.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	@Override
	public List<Material> readMaterialThroughClassRef(String classRef) {
		List<Material> result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<List<Material>> runnable = service.submit(()->{
				Query query =  new Query(Criteria.where("classRef").is(classRef));
				return (List<Material>)dao.readWithQuery(query, Material.class);
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

	@Override
	public Material deleteMaterial(Material mat) {
		Material result = null;
		try {
			ExecutorService service = org.hawks.utils.util.getExecutor();
			Future<Material> runnable = service.submit(()->{
				dao.delete(mat);
				return mat;
			});
			result = runnable.get();
			service.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Error ocurred: "+ex.getMessage());
		}
		return result;
	}

}
