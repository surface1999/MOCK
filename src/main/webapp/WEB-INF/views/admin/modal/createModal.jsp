<!-- Modal -->
<!--  -->
<div class="modal fade" id="createModal" tabindex="-1"
	aria-labelledby="createModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="card card-primary">
					<form:form action="" method="POST" modelAttribute="product"
						enctype="multipart/form-data">
						<div class="card-body">
							<div class="form-group">
								<label for="name">Product name</label>
								<form:input path="productName" type="text" class="form-control"
									id="name" placeholder="Enter product name" />
							</div>
							<div class="form-group">
								<label for="manufacture">Manufacture</label>
								<form:select path="productManufacture.manufactureId"
									class="custom-select" value="${manufacture.getManufactureId()}">
									<c:forEach var="manufacture" items="${manufactures}">
										<option value="${manufacture.getManufactureId()}" >${manufacture.getManufactureName()}
										<option />
									</c:forEach>
								</form:select>
							</div>
							<div class="form-group">
								<label for="price">Price($)</label>
								<form:input path="productPrice" type="number"
									class="form-control" id="price" min="2000000"
									placeholder="Enter product price" />
							</div>
							<div class="form-group">
								<label for="productImage">Product Image</label>
								<div class="input-group">
									<div class="custom-file">
										<form:input path="productImage" type="file"
											accept=".jpg, .png, .jpeg|image/*" class="custom-file-input"
											id="productImage" />
										<label class="custom-file-label" for="exampleInputFile">Choose
											product image</label>
									</div>
								</div>
							</div>
							<!-- Start Config -->
							<div class="form-group">
								<label for="price">Product Config</label>
							</div>
							<div class="form-group">
								<label for="display">Display</label>
								<form:input path="configureOfProduct.display" type="text"
									class="form-control" id="display"
									placeholder="Enter display of product" />
							</div>
							<div class="form-group">
								<label for="os">OS</label>
								<form:input path="configureOfProduct.os" type="text"
									class="form-control" id="os" placeholder="Enter OS of product" />
							</div>
							<div class="form-group">
								<label for="frontCamera">Font Camera</label>
								<form:input path="configureOfProduct.frontCamera" type="text"
									class="form-control" id="frontCamera"
									placeholder="Enter Front Camera of product" />
							</div>
							<div class="form-group">
								<label for="rearCamera">Rear Camera</label>
								<form:input path="configureOfProduct.rearCamera" type="text"
									class="form-control" id="rearCamera"
									placeholder="Enter Rear camera of product" />
							</div>
							<div class="form-group">
								<label for="ram">RAM</label>
								<form:input path="configureOfProduct.ram" type="text"
									class="form-control" id="ram"
									placeholder="Enter RAm of product" />
							</div>
							<div class="form-group">
								<label for="rom">ROM</label>
								<form:input path="configureOfProduct.rom" type="text"
									class="form-control" id="rom"
									placeholder="Enter ROM of product" />
							</div>
							<div class="form-group">
								<label for="sim">SIM</label>
								<form:input path="configureOfProduct.sim" type="text"
									class="form-control" id="sim"
									placeholder="Enter SIM of product" />
							</div>
							<div class="form-group">
								<label for="battery">Battery</label>
								<form:input path="configureOfProduct.battery" type="text"
									class="form-control" id="battery"
									placeholder="Enter product battery" />
							</div>
							<!-- End of Config -->
						</div>

						<!-- /.card-body -->

						<div class="card-footer">
							<button id="btn-add-update" type="submit" class="btn btn-success">Add new</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
