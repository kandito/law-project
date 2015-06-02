
package exes.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the exes.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetUserResponse_QNAME = new QName("http://WS/", "getUserResponse");
    private final static QName _GetCategoryResponse_QNAME = new QName("http://WS/", "getCategoryResponse");
    private final static QName _GetUser_QNAME = new QName("http://WS/", "getUser");
    private final static QName _OperationResponse_QNAME = new QName("http://WS/", "operationResponse");
    private final static QName _UpdateCategory_QNAME = new QName("http://WS/", "updateCategory");
    private final static QName _UpdateTransaction_QNAME = new QName("http://WS/", "updateTransaction");
    private final static QName _AddCategoryResponse_QNAME = new QName("http://WS/", "addCategoryResponse");
    private final static QName _GetCategory_QNAME = new QName("http://WS/", "getCategory");
    private final static QName _DeleteTransaction_QNAME = new QName("http://WS/", "deleteTransaction");
    private final static QName _DeleteTransactionResponse_QNAME = new QName("http://WS/", "deleteTransactionResponse");
    private final static QName _DeleteCategory_QNAME = new QName("http://WS/", "deleteCategory");
    private final static QName _AddCategory_QNAME = new QName("http://WS/", "addCategory");
    private final static QName _AddTransactionResponse_QNAME = new QName("http://WS/", "addTransactionResponse");
    private final static QName _UpdateTransactionResponse_QNAME = new QName("http://WS/", "updateTransactionResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://WS/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://WS/", "hello");
    private final static QName _AddTransaction_QNAME = new QName("http://WS/", "addTransaction");
    private final static QName _UpdateCategoryResponse_QNAME = new QName("http://WS/", "updateCategoryResponse");
    private final static QName _Operation_QNAME = new QName("http://WS/", "operation");
    private final static QName _DeleteCategoryResponse_QNAME = new QName("http://WS/", "deleteCategoryResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: exes.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetCategoryResponse }
     * 
     */
    public GetCategoryResponse createGetCategoryResponse() {
        return new GetCategoryResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link UpdateCategory }
     * 
     */
    public UpdateCategory createUpdateCategory() {
        return new UpdateCategory();
    }

    /**
     * Create an instance of {@link UpdateTransaction }
     * 
     */
    public UpdateTransaction createUpdateTransaction() {
        return new UpdateTransaction();
    }

    /**
     * Create an instance of {@link AddCategoryResponse }
     * 
     */
    public AddCategoryResponse createAddCategoryResponse() {
        return new AddCategoryResponse();
    }

    /**
     * Create an instance of {@link GetCategory }
     * 
     */
    public GetCategory createGetCategory() {
        return new GetCategory();
    }

    /**
     * Create an instance of {@link DeleteTransaction }
     * 
     */
    public DeleteTransaction createDeleteTransaction() {
        return new DeleteTransaction();
    }

    /**
     * Create an instance of {@link DeleteTransactionResponse }
     * 
     */
    public DeleteTransactionResponse createDeleteTransactionResponse() {
        return new DeleteTransactionResponse();
    }

    /**
     * Create an instance of {@link DeleteCategory }
     * 
     */
    public DeleteCategory createDeleteCategory() {
        return new DeleteCategory();
    }

    /**
     * Create an instance of {@link AddCategory }
     * 
     */
    public AddCategory createAddCategory() {
        return new AddCategory();
    }

    /**
     * Create an instance of {@link AddTransactionResponse }
     * 
     */
    public AddTransactionResponse createAddTransactionResponse() {
        return new AddTransactionResponse();
    }

    /**
     * Create an instance of {@link UpdateTransactionResponse }
     * 
     */
    public UpdateTransactionResponse createUpdateTransactionResponse() {
        return new UpdateTransactionResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link AddTransaction }
     * 
     */
    public AddTransaction createAddTransaction() {
        return new AddTransaction();
    }

    /**
     * Create an instance of {@link UpdateCategoryResponse }
     * 
     */
    public UpdateCategoryResponse createUpdateCategoryResponse() {
        return new UpdateCategoryResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link DeleteCategoryResponse }
     * 
     */
    public DeleteCategoryResponse createDeleteCategoryResponse() {
        return new DeleteCategoryResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link TransactionWrapper }
     * 
     */
    public TransactionWrapper createTransactionWrapper() {
        return new TransactionWrapper();
    }

    /**
     * Create an instance of {@link CategoryWrapper }
     * 
     */
    public CategoryWrapper createCategoryWrapper() {
        return new CategoryWrapper();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getCategoryResponse")
    public JAXBElement<GetCategoryResponse> createGetCategoryResponse(GetCategoryResponse value) {
        return new JAXBElement<GetCategoryResponse>(_GetCategoryResponse_QNAME, GetCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "updateCategory")
    public JAXBElement<UpdateCategory> createUpdateCategory(UpdateCategory value) {
        return new JAXBElement<UpdateCategory>(_UpdateCategory_QNAME, UpdateCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "updateTransaction")
    public JAXBElement<UpdateTransaction> createUpdateTransaction(UpdateTransaction value) {
        return new JAXBElement<UpdateTransaction>(_UpdateTransaction_QNAME, UpdateTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "addCategoryResponse")
    public JAXBElement<AddCategoryResponse> createAddCategoryResponse(AddCategoryResponse value) {
        return new JAXBElement<AddCategoryResponse>(_AddCategoryResponse_QNAME, AddCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "getCategory")
    public JAXBElement<GetCategory> createGetCategory(GetCategory value) {
        return new JAXBElement<GetCategory>(_GetCategory_QNAME, GetCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "deleteTransaction")
    public JAXBElement<DeleteTransaction> createDeleteTransaction(DeleteTransaction value) {
        return new JAXBElement<DeleteTransaction>(_DeleteTransaction_QNAME, DeleteTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "deleteTransactionResponse")
    public JAXBElement<DeleteTransactionResponse> createDeleteTransactionResponse(DeleteTransactionResponse value) {
        return new JAXBElement<DeleteTransactionResponse>(_DeleteTransactionResponse_QNAME, DeleteTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "deleteCategory")
    public JAXBElement<DeleteCategory> createDeleteCategory(DeleteCategory value) {
        return new JAXBElement<DeleteCategory>(_DeleteCategory_QNAME, DeleteCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "addCategory")
    public JAXBElement<AddCategory> createAddCategory(AddCategory value) {
        return new JAXBElement<AddCategory>(_AddCategory_QNAME, AddCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "addTransactionResponse")
    public JAXBElement<AddTransactionResponse> createAddTransactionResponse(AddTransactionResponse value) {
        return new JAXBElement<AddTransactionResponse>(_AddTransactionResponse_QNAME, AddTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "updateTransactionResponse")
    public JAXBElement<UpdateTransactionResponse> createUpdateTransactionResponse(UpdateTransactionResponse value) {
        return new JAXBElement<UpdateTransactionResponse>(_UpdateTransactionResponse_QNAME, UpdateTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "addTransaction")
    public JAXBElement<AddTransaction> createAddTransaction(AddTransaction value) {
        return new JAXBElement<AddTransaction>(_AddTransaction_QNAME, AddTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "updateCategoryResponse")
    public JAXBElement<UpdateCategoryResponse> createUpdateCategoryResponse(UpdateCategoryResponse value) {
        return new JAXBElement<UpdateCategoryResponse>(_UpdateCategoryResponse_QNAME, UpdateCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://WS/", name = "deleteCategoryResponse")
    public JAXBElement<DeleteCategoryResponse> createDeleteCategoryResponse(DeleteCategoryResponse value) {
        return new JAXBElement<DeleteCategoryResponse>(_DeleteCategoryResponse_QNAME, DeleteCategoryResponse.class, null, value);
    }

}
