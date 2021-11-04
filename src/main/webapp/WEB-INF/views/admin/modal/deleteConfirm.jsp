
<!-- Modal -->
<div class="modal fade" id="deleteConfirm${product.getProductId()}" tabindex="-1" aria-labelledby="deleteConfirmlLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Are you sure delete <span class="text-danger"> ${product.getProductManufacture().getManufactureName()}&nbsp;${product.getProductName()}</span>?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        This change will reflect in your portal after an hour.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
       <a href="products/delete/${product.getProductId()}" class="btn btn-danger" role="button" aria-pressed="true">Delete</a>
      </div>
    </div>
  </div>
</div>