@Component
public class DeleteProductActionHandler extends AbstractTaskActionHandler<DeleteProductAction, DeleteProductResult> {
	@Override
	public DeleteProductResult execute(DeleteProductAction action, ExecutionContext context) throws DispatchException {
		try {
			getService(action.getProjectId()).deleteProduct(action.getProductId());
			return new DeleteProductResult(action.getProductId());
		} catch (EntityNotFoundException e) {
			handle(e);
		} catch (ValidationException e) {
			handle(e);
		}
		throw new IllegalStateException();
	}
}