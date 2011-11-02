package productAction;

import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.upload.FormFile;

import lib.ServiceFinder;
import bol.*;
import domain.*;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 3699995932467238092L;
	private String id;
	private String productTypeID;
	private String name;
	private String price;
	private String content;
	private String images;
	private File upload;// The actual file
	private String uploadContentType; // The content type of the file
	private String uploadFileName; // The uploaded file name
	private String fileCaption;// The caption of the file entered by userzz

	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String[] arrRemove = request.getParameterValues("cbRemove");
			IProductBO IProductBO = (IProductBO) ServiceFinder.getContext(
					request).getBean("productAOP");
			if (arrRemove != null) {
				for (String string : arrRemove) {
					int id = Integer.parseInt(string);
					IProductBO.delete(IProductBO.getById(id));
				}
			}
			return SUCCESS;
		} catch (Exception ex) {
			addActionError(ex.toString());
			ex.printStackTrace();
		}

		return ERROR;
	}

	public String create() {
		HttpServletRequest request = ServletActionContext.getRequest();

		try {
			
			String filePath = ServletActionContext.getServletContext().getRealPath("/") + "images/cars";
			File fileToCreate = new File(filePath);
			FileUtils.copyFileToDirectory(upload, fileToCreate);
			
			images = upload.getName();
			
			System.out.println(filePath);
			
			int typeID = Integer.parseInt(productTypeID);
			System.out.println(name);
			System.out.println(content);
			Producttype productType = new Producttype(typeID);

			Products entity = new Products();
			entity.setContent(content);
			entity.setImages(images);
			entity.setName(name);
			float productPrice = Float.parseFloat(price);
			entity.setPrice(productPrice);
			entity.setProducttype(productType);

			IProductBO IProductBO = (IProductBO) ServiceFinder.getContext(
					request).getBean("productAOP");
			IProductBO.addNew(entity);
		} catch (Exception ex) {

			addActionError(ex.toString());
			ex.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			if(upload != null){
				String filePath = ServletActionContext.getServletContext().getRealPath("/") + "images/cars";
				File fileToCreate = new File(filePath);
				FileUtils.copyFileToDirectory(upload, fileToCreate);
				
				images = upload.getName();
			}
			
			int typeID = Integer.parseInt(productTypeID);
			Producttype productType = new Producttype(typeID);
			
			Products entity = new Products();
			int productID = Integer.parseInt(id);
			entity.setId(productID);
			entity.setContent(content);
			entity.setImages(images);
			entity.setName(name);
			float productPrice = Float.parseFloat(price);
			entity.setPrice(productPrice);
			entity.setProducttype(productType);

			IProductBO IProductBO = (IProductBO) ServiceFinder.getContext(
					request).getBean("productAOP");
			IProductBO.update(entity);
		} catch (Exception ex) {
			try {
				response.sendRedirect("productDetail.jsp?id=" + id
						+ "&action=edit");
			} catch (IOException e) {
				e.printStackTrace();
			}
			addActionError(ex.toString());
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductTypeID() {
		return productTypeID;
	}

	public void setProductTypeID(String productTypeID) {
		this.productTypeID = productTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileCaption() {
		return fileCaption;
	}

	public void setFileCaption(String fileCaption) {
		this.fileCaption = fileCaption;
	}
}
