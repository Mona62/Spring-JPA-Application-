<%@include file="/WEB-INF/views/includes/header.jsp"%>
<%@include file="/WEB-INF/views/includes/navi.jsp"%>

<div class="col-lg-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Manage Employee</h3>
		</div>
		<div class="panel-body">
		  <c:if test="${success != null}">
                 <div class="alert alert-success">
                     <p>${success}</p>
                 </div>
           </c:if>
		  <c:if test="${fail != null}">
                 <div class="alert alert-danger">
                     <p>${fail}</p>
                 </div>
           </c:if>
			<form action="<c:url value="/addEmp"/>" method="POST">
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="col-lg-3">
				<label for="firstName">FirstName:</label>
			    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="firstName" required="required"/>
			</div>
			<div class="col-lg-3">
				<label for="lastName">LastName:</label>
			    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="lastName" required="required"/>
			</div>
			<div class="col-lg-4">
				<label for="age">age:</label>
			    <input type="text" class="form-control" id="age" name="age" placeholder="age"/>
			    <small class="text-muted"></small>
			</div>
			<div class="col-lg-4">
				<label for="contact">Contact:</label>
			    <input type="text" class="form-control" id="contact" name="contact" placeholder="Contact"/>
			</div>
			<div class="col-lg-12">
				<label for="address">address</label>
			    <textarea class="form-control" id="address" name="address" placeholder="address"></textarea>
			</div>
			
<!-- 			<div class="col-lg-12"> -->
<!-- 				<label for="department">department</label> -->
<!-- 			    <textarea class="form-control" id="dept_id" name="dept_id" placeholder="department"></textarea> -->
<!-- 			</div> -->
			
			
			<div class="col-lg-4">
				<label for="department" >department</label>
				<select name="dept_id" id="dept_id"  required>
					<option  disabled selected>Select your option</option>
					<c:forEach var="deptList" items="${deptList}">
			            <option value="${deptList.id }">${deptList.name}</option>
			        </c:forEach>
				</select>
			
			</div>
			<div class="col-lg-12"  style="margin-top: 20px">
				<button type="submit" class="btn btn-primary">Add</button>
				<button type="reset" class="btn">Reset</button>
			</div>
			
			</form>
		</div>

	</div>

</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>
