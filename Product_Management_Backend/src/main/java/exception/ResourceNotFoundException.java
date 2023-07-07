package exception;


public class ResourceNotFoundException extends RuntimeException
{

			private static final long serialVersionUID = 1L;
		
		private String resourceName; // Name of the resource that was not found
		private String fieldName; // Field name that caused the resource not found exception
		private Object fieldValue; // Field value that caused the resource
		
		
		
		public ResourceNotFoundException() {
			super();
		}

		public String getResourceName() {
			return resourceName;
		}

		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public Object getFieldValue() {
			return fieldValue;
		}



		public void setFieldValue(Object fieldValue) {
			this.fieldValue = fieldValue;
		}



		public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
			// Call the constructor of the parent RuntimeException class with a formatted error message
			// using the provided resource name, field name, and field value
			super(String.format("%s not found with %s : '%s'",resourceName,fieldName,fieldValue));
			
			// Set the values of the resource name, field name, and field value
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fieldValue=fieldValue;
		}	
}
