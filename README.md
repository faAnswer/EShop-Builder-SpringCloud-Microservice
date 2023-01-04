@startuml
interface org.tecky.productservice.mapper.CategoryDetailEntityRepository {
+ List<CategoryDetailEntity> findAllCategoryByClientId(String)
+ List<CategoryDetailEntity> findAll()
  }
  class org.tecky.common.dto.OnHandQtyRecordDTO {
- Integer refId
- Integer onhandDiff
- Integer inventoryId
- Integer shipmentId
  }
  class org.tecky.common.dto.PropertyDTO {
- Integer groupId
- String colaValue
  }
  class org.tecky.orderservice.OrderServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.storageservice.controller.ResourceController {
  ~ IStorageService iStorageService
- Pattern pattern
+ ResponseEntity<?> upload(MultipartFile,String)
  }
  class org.tecky.common.dto.PostWarehouseInShipmentDTO {
- String shippmentCompany
- Integer warehouserId
- String shippmentNum
- String progressStatus
- String directionType
- List<PostWarehouseInDTO> postWarehouseInDTOList
  }
  class org.tecky.productservice.controller.ProductController {
  }
  class org.tecky.inventoryservice.entities.InventoryDetailEntity {
- Integer inventoryId
- String expiryDate
- String additionMsg
- String supplier
- String supplierContact
- String batchNo
  }
  class org.tecky.uuaservice.entities.ClientEntity {
- int clientUid
- String clientName
- String clientId
  }
  class org.tecky.inventoryservice.service.impl.InventoryServiceImpl {
  ~ InventorySecDetailEntityRepository inventorySecDetailEntityRepository
  ~ InventorySecDetailO2MRepository inventorySecDetailO2MRepository
+ ResponseEntity<?> createInventory(PostInventoryDTO)
+ ResponseEntity<?> getSummary(Integer)
+ ResponseEntity<?> getRecord(Integer)
  }
  interface org.tecky.cloudcommon.api.IProductService {
  }
  class org.tecky.mvcwebcommon.MvcWebCommonApplication {
+ {static} void main(String[])
  }
  class MavenWrapperDownloader {
- {static} String WRAPPER_VERSION
- {static} String DEFAULT_DOWNLOAD_URL
- {static} String MAVEN_WRAPPER_PROPERTIES_PATH
- {static} String MAVEN_WRAPPER_JAR_PATH
- {static} String PROPERTY_NAME_WRAPPER_URL
+ {static} void main(String[])
- {static} void downloadFileFromURL(String,File)
  }
  class org.tecky.productservice.controller.ProductGroupController {
  ~ IProductService iProductService
+ ResponseEntity<?> postGroup(PostGroupDTO)
+ ResponseEntity<?> postProduct(PostProductDTO)
+ ResponseEntity<?> getProductGroupList(String,Integer)
+ ResponseEntity<?> getProducts(Integer)
+ ResponseEntity<?> getProperty(Integer)
+ ResponseEntity<?> getSubProperty(Integer,String)
+ ResponseEntity<?> getProduct(Integer,String,String)
+ ResponseEntity<?> getProduct(Integer)
  }
  class org.tecky.common.dto.PostInventoryDTO {
- Integer productId
- String batchNo
- String expiryDate
- String additionMsg
- String supplier
- String supplierContact
+ void setExpiryDate(String)
  }
  interface org.tecky.orderservice.mapper.OrderS2MDetailEntityRepository {
  }
  class org.tecky.common.dto.InventoryDTO {
- Integer inventoryId
- Integer onhandQty
- Integer availableQty
- Integer accountingQty
  }
  class org.tecky.inventoryservice.entities.AvailableDetailEntity {
- Integer refId
- Integer inventoryId
- Integer availableDiff
- Integer orderId
  }
  class org.tecky.warehouseservice.entities.ShipmentEntity {
- int shippmentId
- String shippmentCompany
- int warehouserId
- String shippmentNum
- String progressStatus
- String directionType
  }
  class org.tecky.inventoryservice.entities.InventorySecDetailEntity {
- Integer inventoryId
- Integer productId
- Integer accountingQty
- Integer availableQty
- Integer onhandQty
- String expiryDate
- String additionMsg
- String supplier
- String supplierContact
- String batchNo
  }
  class org.tecky.common.CommonApplicationTests {
  ~ void contextLoads()
  }
  interface org.tecky.productservice.mapper.GroupDetailEntityRepository {
+ GroupDetailEntity findByGroupId(Integer)
+ List<GroupDetailEntity> findByTypeIdAndClientId(Integer,String)
  }
  class org.tecky.common.dto.PostWarehouseInDTO {
- String refPic
- Integer inventoryId
- Integer qty
- String recordRef
- Integer handlerUid
- String additionMsg
- Integer shippmentId
  }
  class org.tecky.warehouseservice.entities.InDetailEntity {
- int recordId
- String refPic
- int inventoryId
- int qty
- String recordRef
- int handlerUid
- String additionMsg
- String shippmentId
  }
  class org.tecky.uuaservice.controller.AdminController {
  ~ IAdminService iAdminService
+ ResponseEntity<?> registerAdmin(PostAdminRegDTO)
+ ResponseEntity<?> createRole(PostRoleDTO)
+ ResponseEntity<?> createScope(PostRoleDTO)
+ ResponseEntity<?> delScope(PostRoleDTO)
  }
  class org.tecky.uuaservice.security.CustomUserDetailsService {
  ~ ClientSecUserEntityRepository clientSecUserEntityRepository
  ~ RoleAuthS2OScopeEntityRepository roleAuthS2OScopeEntityRepository
- String clientId
+ void setClientId(String)
+ UserDetails loadUserByUsername(String)
  }
  class org.tecky.warehouseservice.entities.OutDetailEntity {
- int recordId
- String refPic
- int inventoryId
- int qty
- int handlerUid
- int orderId
- String additionMsg
  }
  class org.tecky.productservice.ProductServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.nacosconfig.NacosConfigApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.inventoryservice.controller.TestContoller {
  ~ InventorySecDetailO2MRepository inventorySecDetailO2MRepository
+ String test()
  }
  interface org.tecky.inventoryservice.mapper.InventorySecDetailEntityRepository {
+ InventorySecDetailEntity findByProductIdAndBatchNo(Integer,String)
+ List<InventorySecDetailEntity> findByProductId(Integer)
  }
  interface org.tecky.uuaservice.service.intf.IAdminService {
+ ResponseEntity<?> adminRegister(PostAdminRegDTO)
+ ResponseEntity<?> createRole(PostRoleDTO)
+ ResponseEntity<?> createScope(PostRoleDTO)
+ ResponseEntity<?> delScope(PostRoleDTO)
  }
  class org.tecky.storageservice.security.config.WebSecurityConfig {
+ SecurityFilterChain securityFilterChain(HttpSecurity)
  ~ CorsConfigurationSource corsConfigurationSource()
  }
  class org.tecky.common.dto.AvailQtyRecordDTO {
- Integer refId
- Integer inventoryId
- Integer availableDiff
- Integer orderId
  }
  class org.tecky.common.dto.PostAdminRegDTO {
- String clientId
- String password
- String email
- String username
- Integer roleId
  }
  interface org.tecky.warehouseservice.mapper.ShipmentS2MInDetailEntityRepository {
  }
  interface org.tecky.couponservice.mapper.CouponSecDetailEntityRepository {
+ CouponSecDetailEntity findByCouponNameAndClientUid(String,Integer)
+ CouponSecDetailEntity findByCouponId(Integer)
  }
  class org.tecky.inventoryservice.nacosconfig.NacosConfigConfiguration {
  }
  class org.tecty.gateway.GatewayApplication {
+ {static} void main(String[])
  }
  class org.tecky.productservice.entities.TypeDetailEntity {
- Integer typeId
- String typeName
  }
  class org.tecky.couponservice.config.SeataRestTemplateConfiguration {
- Collection<RestTemplate> restTemplates
+ SeataFilter seataFilter()
+ SeataRestTemplateInterceptor seataRestTemplateInterceptor()
+ void init()
  }
  class org.tecky.warehouseservice.entities.InDetailM2SShipmentEntity {
- Integer recordId
- String refPic
- Integer inventoryId
- Integer qty
- String recordRef
- Integer handlerUid
- String additionMsg
- ShipmentS2MInDetailEntity shipmentS2MInDetailEntity
  }
  class org.tecky.mvcwebcommon.filter.SeataFilter {
+ void init(FilterConfig)
+ void doFilter(ServletRequest,ServletResponse,FilterChain)
+ void destroy()
  }
  class org.tecky.orderservice.config.RestTemplateConfig {
  ~ SeataRestTemplateInterceptor seataRestTemplateInterceptor
+ RestTemplate restTemplate()
  }
  class org.tecky.common.dto.PostCouponDTO {
- String couponName
- Integer uid
- Integer clientUid
- String expiryDate
- Integer availableQty
- String couponDescription
- Integer typeId
- Integer var3
- Integer var2
- Integer var1
+ void setExpiryDate(String)
  }
  class org.tecky.common.dto.PostRoleDTO {
- String roleName
- String clientId
- List<Integer> scopeIdList
  }
  class org.tecky.uuaservice.entities.UserEntity {
- int uid
- int roleId
- int clientUid
- String shapassword
- String email
- String username
  }
  class org.tecky.inventoryservice.entities.OnhandDetailM2OEntity {
- Integer refId
- Integer onhandDiff
- Integer shipmentId
- InventorySecDetailO2MEntity inventorySecDetailO2MEntity
  }
  class org.tecky.storageservice.nacosdiscovery.NacosDiscoveryConfiguration {
  }
  class org.tecky.cloudcommon.CloudCommonApplication {
+ {static} void main(String[])
  }
  class org.tecky.uuaservice.controller.HelloController {
+ String hello()
  }
  class org.tecky.productservice.service.CategoryChecker {
- TypeEntityRepository typeEntityRepository
- TypeDetailEntityRepository typeDetailEntityRepository
- CategoryDetailEntityRepository categoryDetailEntityRepository
- Map<Integer,Integer> typeMap
- Map<Integer,String> typeNameMap
- Map<Integer,String> categoryNameMap
- Map<String,List<String>> categoryTypeNameMap
- Map<Integer,List<Integer>> categoryTypeIdMap
- Map<Integer,Map<Integer,String>> categoryTypeFullMap
+ boolean containsTypeId(Integer)
+ boolean containsCategoryId(Integer)
+ String typeName(Integer)
+ String categoryName(Integer)
  }
  class org.tecky.uuaservice.controller.TestController {
  ~ RoleAuthS2OScopeEntityRepository roleAuthS2OScopeEntityRepository
  ~ RoleAuthEntityRepository roleAuthEntityRepository
+ String getTest()
+ String security()
  }
  class org.tecky.graphqlservice.controller.ProductController {
  ~ FeignProductServiceAPI feignProductServiceAPI
  ~ String productService
+ ClientDTO client(String)
+ List<CategoryDTO> categoryList()
+ CategoryDTO category(Integer)
+ List<CategoryDTO> category(ClientDTO)
+ List<CategoryTypeDTO> categoryType(CategoryDTO)
+ List<ProductGroupDTO> productGroup(CategoryTypeDTO)
+ List<PropertyDTO> property(ProductGroupDTO)
+ List<SubPropertyDTO> subProperty(PropertyDTO)
+ ProductDTO product(SubPropertyDTO)
  }
  interface org.tecky.common.api.productservice.ProductServiceAPI {
  }
  interface org.tecky.warehouseservice.mapper.ShipmentEntityRepository {
  }
  class org.tecky.orderservice.service.impl.OrderServiceImpl {
  ~ RestTemplate restTemplate
  ~ OrderS2MDetailEntityRepository orderS2MDetailEntityRepository
+ ResponseEntity<?> createOrder(PostOrderDTO)
  }
  class org.tecky.warehouseservice.controller.TestController {
  ~ ShipmentS2MInDetailEntityRepository shipmentS2MInDetailEntityRepository
+ String getTest()
  }
  class org.tecky.common.dto.PostClientLoginDTO {
- String clientId
- String password
- String email
  }
  class org.tecky.warehouseservice.service.impl.WarehouseServiceImpl {
  ~ WarehouseEntityRepository warehouseEntityRepository
+ ResponseEntity<?> createWarehouse(PostWarehouseDTO)
  }
  interface org.tecky.couponservice.mapper.CouponRecordEntityRepository {
  }
  interface org.tecky.orderservice.mapper.OrderEntityRepository {
  }
  class org.tecky.inventoryservice.InventoryServiceApplication {
+ {static} void main(String[])
  }
  interface org.tecky.inventoryservice.service.intf.InventoryService {
+ ResponseEntity<?> createInventory(PostInventoryDTO)
+ ResponseEntity<?> getSummary(Integer)
+ ResponseEntity<?> getRecord(Integer)
  }
  class org.tecty.gateway.GatewayApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.orderservice.entities.DetailM2SOrderEntity {
- Integer detailId
- String amount
- Integer productId
- Integer qty
- OrderS2MDetailEntity orderS2MDetailEntity
  }
  class org.tecky.couponservice.entities.CouponRecordEntity {
- Integer recordId
- Integer couponId
- Integer orderId
- String useDatetime
- Integer discount
  }
  class org.tecky.productservice.entities.GroupDetailEntity {
- Integer groupId
- String colbKey
- String groupName
- String colaKey
- Integer typeId
- String picUrl
- String groupDescription
- String clientId
- Integer isvalid
  }
  class org.tecky.couponservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  interface org.tecky.couponservice.mapper.CouponTypeEntityRepository {
+ CouponTypeEntity findByTypeId(Integer)
  }
  interface org.tecky.inventoryservice.mapper.AccountingDetailEntityRepository {
  }
  class org.tecky.orderservice.entities.OrderEntity {
- Integer orderId
- String shippingAmount
- Integer uid
- String orderStatus
- Integer couponId
- String totalAmount
- String subtotal
- String discountAmount
- Integer clientUid
  }
  interface org.tecky.inventoryservice.mapper.InventoryDetailEntityRepository {
  }
  interface org.tecky.graphqlservice.feign.FeignInventoryServiceAPI {
  }
  class org.tecky.productservice.ProductServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.couponservice.entities.CouponEntity {
- Integer couponId
- Integer uid
- Integer clientUid
- String expiryDate
- Integer availableQty
  }
  class org.tecky.uuaservice.security.WebSecurityConfig {
- String jwtSecret
  ~ CustomUserDetailsService customUserDetailsService
+ PasswordEncoder passwordEncoder()
+ OncePerRequestFilter oncePerRequestFilter()
+ AuthenticationManager authenticationProvider()
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  class org.tecky.common.dto.PostProductDTO {
- Integer groupId
- String clientId
- String colaValue
- String colbValue
  }
  interface org.tecky.warehouseservice.mapper.WarehouseEntityRepository {
+ WarehouseEntity findByWarehouseNameAndClientUid(String,Integer)
+ WarehouseEntity findByWarehouseId(Integer)
  }
  class org.tecky.productservice.entities.comprimarykey.GroupEntityPK {
- Integer groupId
- Integer productId
  }
  interface org.tecky.productservice.service.intf.IProductService {
+ ResponseEntity<?> insertProductGroup(PostGroupDTO)
+ ResponseEntity<?> insertProduct(PostProductDTO)
+ ResponseEntity<?> findProductGroup(Integer)
+ ResponseEntity<?> findProductGroupList(String,Integer)
+ ResponseEntity<?> findProductProperties(Integer)
+ ResponseEntity<?> findProductSubProperties(Integer,String)
+ ResponseEntity<?> findProduct(Integer,String,String)
  }
  class org.tecky.inventoryservice.entities.AvailableDetailM2OEntity {
- Integer refId
- Integer availableDiff
- Integer orderId
- InventorySecDetailO2MEntity inventorySecDetailO2MEntity
  }
  class org.tecky.nacosconfig.NacosConfigApplication {
+ {static} void main(String[])
  }
  class org.tecky.graphqlservice.GraphqlServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.couponservice.controller.CouponController {
  ~ ICouponService iCouponService
- KafkaTemplate<String,Object> kafkaTemplate
+ ResponseEntity<?> createCoupon(PostCouponDTO)
+ ResponseEntity<?> getDiscount(PatchCouponDTO)
+ ResponseEntity<?> patchCoupon(PatchCouponDTO)
}
interface org.tecky.common.api.inventoryservice.InventoryAPI {
~ ResponseEntity<?> postInventory(PostInventoryDTO)
  ~ ResponseEntity<?> getQty(Integer)
~ ResponseEntity<?> getRecords(Integer)
  }
  class MavenWrapperDownloader {
- {static} String WRAPPER_VERSION
- {static} String DEFAULT_DOWNLOAD_URL
- {static} String MAVEN_WRAPPER_PROPERTIES_PATH
- {static} String MAVEN_WRAPPER_JAR_PATH
- {static} String PROPERTY_NAME_WRAPPER_URL
+ {static} void main(String[])
- {static} void downloadFileFromURL(String,File)
  }
  class org.tecky.productservice.controller.TypeController {
  ~ ICategoryService iCategoryService
+ ResponseEntity<?> getTypes(Integer)
+ ResponseEntity<?> getType(Integer,String)
  }
  class org.tecky.couponservice.entities.CouponTypeEntity {
- Integer typeId
- String typeName
- String condition1Description
- String condition2Description
- String typeDescription
- String var1Type
- String var2Type
- String var3Type
  }
  class org.tecky.graphqlservice.config.MyLoadBalancerConfig {
  ~ NacosDiscoveryProperties nacosDiscoveryProperties
  ~ ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment,LoadBalancerClientFactory)
  }
  class org.tecky.warehouseservice.entities.WarehouseEntity {
- Integer warehouseId
- String warehouseName
- Integer warehouseTel
- String warehouseAddress
- Integer clientUid
  }
  class org.tecky.graphqlservice.GraphqlServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.warehouseservice.service.impl.ShipmentServiceImpl {
  ~ WarehouseEntityRepository warehouseEntityRepository
  ~ ShipmentS2MInDetailEntityRepository shipmentS2MInDetailEntityRepository
+ ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO)
  }
  class org.tecky.uuaservice.entities.ScopeEntity {
- int scopeId
- String scopeDescription
- String scopeName
  }
  class org.tecky.warehouseservice.entities.StockEntity {
- int inventoryId
- int stockQty
- int warehouserId
  }
  class org.tecky.inventoryservice.entities.AccountingDetailEntity {
- Integer refId
- Integer inventoryId
- Integer paymentId
- Integer accountingDiff
- Integer orderId
  }
  class org.tecky.graphqlservice.controller.HelloController {
+ String getHello()
  }
  interface org.tecky.inventoryservice.mapper.InventorySecDetailO2MRepository {
+ InventorySecDetailO2MEntity findByInventoryId(Integer)
  }
  class org.tecky.orderservice.entities.OrderS2MDetailEntity {
- Integer orderId
- String shippingAmount
- Integer uid
- String orderStatus
- Integer couponId
- String totalAmount
- String subtotal
- String discountAmount
- Integer clientUid
- List<DetailM2SOrderEntity> detailM2SOrderEntityList
  }
  class org.tecky.nacosconfig.controller.NacosConfigController {
- {static} String dataId
- {static} String group
- ConfigService configService
+ boolean publishConfig()
  }
  class org.tecky.nacosconfig.nacosconfig.NacosConfigConfiguration {
+ ConfigService nacosConfigService()
  }
  interface org.tecky.inventoryservice.mapper.AvailableDetailM2OEntityRepository {
  }
  class org.tecky.couponservice.service.impl.CouponServiceImpl {
  ~ CouponEntityRepository couponEntityRepository
  ~ CouponTypeEntityRepository couponTypeEntityRepository
  ~ CouponSecDetailEntityRepository couponSecDetailEntityRepository
  ~ CouponRecordEntityRepository couponRecordEntityRepository
+ ResponseEntity<?> createCoupon(PostCouponDTO)
+ ResponseEntity<?> getCouponDiscount(PatchCouponDTO)
+ ResponseEntity<?> patchCoupon(PatchCouponDTO)
- ResponseEntity<?> type1Coupon(CouponSecDetailEntity,PatchCouponDTO)
- ResponseEntity<?> type2Coupon(CouponSecDetailEntity,PatchCouponDTO)
- ResponseEntity<?> type3Coupon(CouponSecDetailEntity,PatchCouponDTO)
- ResponseEntity<?> type4Coupon(CouponSecDetailEntity,PatchCouponDTO)
  }
  class org.tecky.uuaservice.UuaServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.nacosconfig.controller.TestController {
+ String getConfigInfo()
  }
  class org.tecky.couponservice.security.WebSecurityConfig {
- String jwtSecret
+ OncePerRequestFilter oncePerRequestFilter()
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  class org.tecky.storageservice.nacosconfig.NacosConfigConfiguration {
  }
  interface org.tecky.uuaservice.mapper.UserEntityRepository {
+ UserEntity findByEmailAndRoleId(String,Integer)
+ UserEntity findByUsernameAndRoleId(String,Integer)
+ UserEntity findByEmailAndClientUid(String,Integer)
  }
  class org.tecky.uuaservice.UuaServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecty.gateway.nacosdiscovery.NacosDiscoveryConfiguration {
  }
  interface org.tecky.uuaservice.service.intf.IUserService {
+ ResponseEntity<?> rootRegister(PostClientRegDTO)
+ ResponseEntity<?> clientLogin(PostClientLoginDTO)
  }
  interface org.tecky.inventoryservice.mapper.AvailableDetailEntityRepository {
  }
  class org.tecky.orderservice.config.SeataRestTemplateConfiguration {
+ SeataFilter seataFilter()
+ SeataRestTemplateInterceptor seataRestTemplateInterceptor()
  }
  interface org.tecky.couponservice.service.intf.ICouponService {
+ ResponseEntity<?> createCoupon(PostCouponDTO)
+ ResponseEntity<?> getCouponDiscount(PatchCouponDTO)
+ ResponseEntity<?> patchCoupon(PatchCouponDTO)
  }
  class org.tecky.inventoryservice.entities.AccountingDetailM2OEntity {
- Integer refId
- Integer paymentId
- Integer accountingDiff
- Integer orderId
- InventorySecDetailO2MEntity inventorySecDetailO2MEntity
  }
  class org.tecky.productservice.entities.CategoryDetailEntity {
- Integer categoryId
- String categoryName
  }
  interface org.tecky.warehouseservice.service.intf.IWarehouseService {
+ ResponseEntity<?> createWarehouse(PostWarehouseDTO)
}
interface org.tecky.common.api.productservice.TypeAPI {
~ ResponseEntity<?> getTypes(Integer)
  ~ ResponseEntity<?> getType(Integer,String)
  }
  class MavenWrapperDownloader {
- {static} String WRAPPER_VERSION
- {static} String DEFAULT_DOWNLOAD_URL
- {static} String MAVEN_WRAPPER_PROPERTIES_PATH
- {static} String MAVEN_WRAPPER_JAR_PATH
- {static} String PROPERTY_NAME_WRAPPER_URL
+ {static} void main(String[])
- {static} void downloadFileFromURL(String,File)
  }
  interface org.tecky.warehouseservice.service.intf.IShipmentService {
+ ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO)
  }
  interface org.tecky.productservice.mapper.TypeDetailEntityRepository {
+ List<TypeDetailEntity> findAll()
+ List<TypeDetailEntity> findAllByCategoryIdAndClientId(Integer,String)
  }
  interface org.tecky.productservice.service.intf.ICategoryService {
+ List<CategoryDTO> getCategories(String)
+ List<CategoryDTO> getCategories()
+ CategoryDTO getCategory(Integer)
+ List<CategoryTypeDTO> getTypeByCategoryId(Integer)
+ List<CategoryTypeDTO> getTypeByCategoryId(Integer,String)
  }
  class org.tecky.storageservice.services.impl.StorageServiceImpl {
- MinioProperties minioProperties
  ~ MinioClient minioClient
+ String getObjectUrl(String)
+ ResponseEntity<?> save(String,String,MultipartFile)
  }
  class org.tecky.storageservice.config.MinioProperties {
- String endpoint
- String accessKey
- String secretKey
- String picbucketName
  }
  interface org.tecky.warehouseservice.mapper.InDetailEntityRepository {
  }
  class org.tecky.warehouseservice.controller.WarehouseController {
  ~ IWarehouseService iWarehouseService
+ ResponseEntity<?> createWarehouse(PostWarehouseDTO)
  }
  interface org.tecky.warehouseservice.mapper.StockEntityRepository {
  }
  class org.tecky.uuaservice.entities.RoleAuthS2OScopeEntity {
- int roleId
- int scopeId
- ScopeEntity scopeEntity
  }
  interface org.tecky.warehouseservice.mapper.OutDetailEntityRepository {
  }
  class org.tecky.orderservice.entities.OrderDetailEntity {
- Integer detailId
- String amount
- Integer productId
- Integer qty
- Integer orderId
  }
  class org.tecky.productservice.service.impl.ProductServiceImpl {
  ~ GroupDetailEntityRepository groupDetailEntityRepository
  ~ CategoryChecker categoryChecker
  ~ ProductDetailEntityRepository productDetailEntityRepository
+ ResponseEntity<?> insertProductGroup(PostGroupDTO)
+ ResponseEntity<?> insertProduct(PostProductDTO)
+ ResponseEntity<?> findProductGroup(Integer)
+ ResponseEntity<?> findProductGroupList(String,Integer)
+ ResponseEntity<?> findProductProperties(Integer)
+ ResponseEntity<?> findProductSubProperties(Integer,String)
+ ResponseEntity<?> findProduct(Integer,String,String)
  }
  class org.tecky.uuaservice.service.impl.UserServiceImpl {
- String jwtSecret
  ~ PasswordEncoder passwordEncoder
  ~ UserEntityRepository userEntityRepository
  ~ ClientEntityRepository clientEntityRepository
  ~ ClientSecUserEntityRepository clientSecUserEntityRepository
  ~ CustomUserDetailsService customUserDetailsService
  ~ RoleEntityRepository roleEntityRepository
  ~ AuthenticationManager authenticationManager
+ ResponseEntity<?> rootRegister(PostClientRegDTO)
+ ResponseEntity<?> clientLogin(PostClientLoginDTO)
  }
  class org.tecky.productservice.entities.ProductDetailEntity {
- Integer productId
- String colbValue
- String colaValue
- Integer groupId
- Integer isvalid
  }
  class org.tecky.inventoryservice.entities.OnhandDetailEntity {
- Integer refId
- Integer onhandDiff
- Integer inventoryId
- Integer shipmentId
  }
  interface org.tecky.uuaservice.mapper.ScopeEntityRepository {
+ ScopeEntity findByScopeId(Integer)
  }
  class org.tecky.warehouseservice.controller.ShipmentController {
  ~ IShipmentService iShipmentService
+ ResponseEntity<?> createInShipment(PostWarehouseInShipmentDTO)
  }
  class org.tecky.productservice.entities.TypeEntity {
- Integer typeId
- Integer categoryId
  }
  class org.tecky.common.dto.PostClientRegDTO {
- String clientName
- String clientId
- String password
- String email
- String username
  }
  class org.tecky.productservice.controller.CategoryController {
  ~ ICategoryService iCategoryService
+ ResponseEntity<?> getCategories(String)
+ ResponseEntity<?> getCategories()
+ ResponseEntity<?> getCategory(Integer)
  }
  interface org.tecky.orderservice.mapper.OrderDetailEntityRepository {
  }
  class org.tecky.uuaservice.config.UserDetailsServiceConfig {
  }
  class org.tecky.storageservice.StorageServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.common.dto.SubPropertyDTO {
- Integer groupId
- String colaValue
- String colbValue
  }
  interface org.tecky.uuaservice.mapper.RoleEntityRepository {
+ RoleEntity findByRoleId(Integer)
+ RoleEntity findByRoleNameAndClientUid(String,Integer)
  }
  class org.tecky.uuaservice.entities.RoleEntity {
- int roleId
- String roleName
- int clientUid
  }
  interface org.tecky.inventoryservice.mapper.OnhandDetailEntityRepository {
  }
  interface org.tecky.productservice.mapper.ProductDetailEntityRepository {
+ List<ProductDetailEntity> findByGroupIdAndIsvalidIs(Integer,Integer)
+ List<ProductDetailEntity> findByGroupIdAndColaValue(Integer,String)
+ List<ProductDetailEntity> findDistinctColaValueByGroupId(Integer)
+ ProductDetailEntity findByGroupIdAndColaValueAndColbValue(Integer,String,String)
  }
  interface org.tecky.common.api.productservice.ProductGroupAPI {
  ~ ResponseEntity<?> postGroup(PostGroupDTO)
~ ResponseEntity<?> postProduct(PostProductDTO)
  ~ ResponseEntity<?> getProductGroupList(String,Integer)
~ ResponseEntity<?> getProducts(Integer)
  ~ ResponseEntity<?> getProperty(Integer)
~ ResponseEntity<?> getSubProperty(Integer,String)
  ~ ResponseEntity<?> getProduct(Integer,String,String)
~ ResponseEntity<?> getProduct(Integer)
  }
  class org.tecky.uuaservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  class org.tecky.couponservice.CouponServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.productservice.security.WebSecurityConfig {
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  class org.tecky.productservice.entities.comprimarykey.TypeEntityPK {
- Integer typeId
- Integer categoryId
  }
  interface org.tecky.couponservice.mapper.CouponDetailEntityRepository {
  }
  class org.tecky.common.dto.PatchCouponDTO {
- Integer couponId
- Integer uid
- Integer clientUid
- Integer orderId
- Integer subtotal
  }
  class org.tecky.inventoryservice.security.WebSecurityConfig {
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  class MavenWrapperDownloader {
- {static} String WRAPPER_VERSION
- {static} String DEFAULT_DOWNLOAD_URL
- {static} String MAVEN_WRAPPER_PROPERTIES_PATH
- {static} String MAVEN_WRAPPER_JAR_PATH
- {static} String PROPERTY_NAME_WRAPPER_URL
+ {static} void main(String[])
- {static} void downloadFileFromURL(String,File)
  }
  class org.tecky.inventoryservice.config.SeataRestTemplateConfiguration {
- Collection<RestTemplate> restTemplates
+ SeataFilter seataFilter()
+ SeataRestTemplateInterceptor seataRestTemplateInterceptor()
+ void init()
  }
  class org.tecky.orderservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  class org.tecky.common.dto.CategoryTypeDTO {
- Integer typeId
- String typeName
- String clientId
  }
  class org.tecky.common.dto.ProductGroupDTO {
- Integer groupId
- Integer typeId
- String clientId
- String groupName
- String groupDescription
- String picUrl
- String colaKey
- String colbKey
- Integer isvalid
  }
  class org.tecky.warehouseservice.WarehouseServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecty.gateway.security.config.WebSecurityConfig {
+ SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity)
  }
  class org.tecky.uuaservice.controller.ClientController {
  ~ IUserService iUserService
+ ResponseEntity<?> register(PostClientRegDTO)
+ ResponseEntity<?> login(PostClientLoginDTO)
}
interface org.tecky.common.api.productservice.CategoryAPI {
~ ResponseEntity<?> getCategories(String)
  ~ ResponseEntity<?> getCategories()
~ ResponseEntity<?> getCategory(Integer)
  }
  class org.tecky.uuaservice.entities.RoleAuthEntity {
- int roleId
- int scopeId
  }
  class org.tecky.graphqlservice.controller.InventoryController {
  ~ FeignInventoryServiceAPI feignInventoryServiceAPI
+ InventorySumDTO inventorySum(ProductDTO)
+ InventoryQtyRecordDTO inventoryQtyRecordDTO(InventoryDTO)
  }
  class org.tecky.common.dto.PostGroupDTO {
- String clientId
- Integer typeId
- String groupName
- String groupDescription
- String picUrl
- String colaKey
- String colbKey
  }
  class org.tecky.storageservice.config.MinioConfig {
- MinioProperties minioProperties
+ MinioClient minioClient()
  }
  interface org.tecky.couponservice.mapper.CouponEntityRepository {
+ CouponEntity findByCouponId(Integer)
+ void decrementQty(Integer,Integer)
  }
  interface org.tecky.warehouseservice.mapper.InDetailM2SShipmentEntityRepository {
  }
  class org.tecky.mvcwebcommon.interceptor.SeataRestTemplateInterceptor {
+ ClientHttpResponse intercept(HttpRequest,byte[],ClientHttpRequestExecution)
  }
  class org.tecky.inventoryservice.entities.InventorySecDetailO2MEntity {
- Integer inventoryId
- Integer productId
- Integer accountingQty
- Integer availableQty
- Integer onhandQty
- String expiryDate
- String additionMsg
- String supplier
- String supplierContact
- String batchNo
- List<AvailableDetailM2OEntity> availableDetailM2OEntity
- List<OnhandDetailM2OEntity> onhandDetailM2OEntity
- List<AccountingDetailM2OEntity> accountingDetailM2OEntity
  }
  class org.tecky.productservice.config.CategoryCheckerConfig {
  ~ TypeEntityRepository typeEntityRepository
  ~ TypeDetailEntityRepository typeDetailEntityRepository
  ~ CategoryDetailEntityRepository categoryDetailEntityRepository
+ CategoryChecker categoryChecker()
  }
  interface org.tecky.storageservice.services.intf.IStorageService {
+ String getObjectUrl(String)
+ ResponseEntity<?> save(String,String,MultipartFile)
  }
  interface org.tecky.graphqlservice.feign.FeignProductServiceAPI {
  }
  interface org.tecky.uuaservice.mapper.ClientSecUserEntityRepository {
+ ClientSecUserEntity findByClientIdAndEmail(String,String)
+ ClientSecUserEntity findByClientIdAndUsername(String,String)
  }
  class org.tecky.common.config.KafkaTopicConfig {
+ {static} String COUPON
+ {static} Map<String,Class<?>> map
- {static} ObjectMapper mapper
+ {static} T string2Object(String,Class<T>)
  }
  class org.tecky.warehouseservice.WarehouseServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.orderservice.security.WebSecurityConfig {
- String jwtSecret
+ OncePerRequestFilter oncePerRequestFilter()
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  interface org.tecky.productservice.mapper.TypeEntityRepository {
+ List<TypeEntity> findAllValidType()
  }
  class org.tecky.inventoryservice.InventoryServiceApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.couponservice.CouponServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.common.dto.AuthClientInfoDTO {
- String username
- String clientid
- String name
- String description
- String picuri
  }
  class org.tecky.common.dto.PostWarehouseDTO {
- String warehouseName
- Integer warehouseTel
- String warehouseAddress
- Integer clientUid
  }
  class org.tecky.common.dto.CategoryDTO {
- Integer categoryId
- String categoryName
- String clientId
  }
  class org.tecky.orderservice.controller.OrderController {
  ~ IOrderService iOrderService
+ ResponseEntity<?> postOrder(PostOrderDTO)
  }
  class org.tecky.inventoryservice.controller.HelloController {
+ String hello()
  }
  class org.tecky.uuaservice.entities.ClientSecUserEntity {
- int clientUid
- String clientName
- String clientId
- int uid
- int roleId
- String shapassword
- String email
- String username
  }
  class org.tecky.inventoryservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  class org.tecky.couponservice.controller.TestController {
+ String getTest()
  }
  class org.tecky.couponservice.entities.CouponDetailEntity {
- Integer couponId
- String couponDescription
- Integer typeId
- Integer var3
- Integer var2
- Integer var1
- String couponName
  }
  interface org.tecky.orderservice.mapper.DetailM2SOrderEntityRepository {
  }
  interface org.tecky.orderservice.service.intf.IOrderService {
+ ResponseEntity<?> createOrder(PostOrderDTO)
  }
  class org.tecky.common.dto.ClientDTO {
- String clientId
  }
  class org.tecky.common.dto.AccQtyRecordDTO {
- Integer refId
- Integer inventoryId
- Integer paymentId
- Integer accountingDiff
- Integer orderId
  }
  class org.tecty.gateway.security.config.GatewayCorsConfiguration {
+ CorsWebFilter corsWebFilter()
  }
  class org.tecky.uuaservice.service.impl.AdminServiceImpl {
  ~ PasswordEncoder passwordEncoder
  ~ ClientEntityRepository clientEntityRepository
  ~ UserEntityRepository userEntityRepository
  ~ ClientSecUserEntityRepository clientSecUserEntityRepository
  ~ RoleEntityRepository roleEntityRepository
  ~ RoleAuthEntityRepository roleAuthEntityRepository
  ~ ScopeEntityRepository scopeEntityRepository
+ ResponseEntity<?> adminRegister(PostAdminRegDTO)
+ ResponseEntity<?> createRole(PostRoleDTO)
+ ResponseEntity<?> createScope(PostRoleDTO)
+ ResponseEntity<?> delScope(PostRoleDTO)
+ void createScope(PostRoleDTO,Integer)
  }
  class org.tecky.common.dto.PostOrderProductDTO {
- Integer productId
- Integer qty
  }
  class org.tecky.couponservice.entities.CouponSecDetailEntity {
- Integer couponId
- Integer uid
- Integer clientUid
- String expiryDate
- Integer availableQty
- String couponDescription
- Integer typeId
- Integer var3
- Integer var2
- Integer var1
- String couponName
  }
  class org.tecky.storageservice.StorageServiceApplicationTests {
  ~ void contextLoads()
  }
  class MavenWrapperDownloader {
- {static} String WRAPPER_VERSION
- {static} String DEFAULT_DOWNLOAD_URL
- {static} String MAVEN_WRAPPER_PROPERTIES_PATH
- {static} String MAVEN_WRAPPER_JAR_PATH
- {static} String PROPERTY_NAME_WRAPPER_URL
+ {static} void main(String[])
- {static} void downloadFileFromURL(String,File)
  }
  interface org.tecky.common.api.inventoryservice.InventoryServiceAPI {
  }
  interface org.tecky.uuaservice.mapper.RoleAuthS2OScopeEntityRepository {
+ List<RoleAuthS2OScopeEntity> findByRoleId(Integer)
  }
  class org.tecky.productservice.controller.TestController {
  ~ ProductDetailEntityRepository productDetailEntityRepository
+ String getTest()
  }
  class org.tecky.cloudcommon.CloudCommonApplicationTests {
  ~ void contextLoads()
  }
  class org.tecky.inventoryservice.controller.InventoryController {
  ~ InventoryService inventoryService
+ ResponseEntity<?> postInventory(PostInventoryDTO)
+ ResponseEntity<?> getQty(Integer)
+ ResponseEntity<?> getRecords(Integer)
  }
  class org.tecky.warehouseservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  class org.tecky.warehouseservice.security.WebSecurityConfig {
- String jwtSecret
+ OncePerRequestFilter oncePerRequestFilter()
+ SecurityFilterChain securityWebFilterChain(HttpSecurity)
  }
  class org.tecky.orderservice.OrderServiceApplication {
+ {static} void main(String[])
  }
  class org.tecky.common.CommonApplication {
+ {static} void main(String[])
  }
  class org.tecky.mvcwebcommon.MvcWebCommonApplicationTests {
  ~ void contextLoads()
  }
  interface org.tecky.uuaservice.mapper.ClientEntityRepository {
+ ClientEntity findByClientId(String)
+ ClientEntity findByClientName(String)
  }
  class org.tecky.productservice.service.impl.CategoryServiceImpl {
  ~ CategoryDetailEntityRepository categoryDetailEntityRepository
  ~ TypeDetailEntityRepository typeDetailEntityRepository
  ~ CategoryChecker categoryChecker
+ List<CategoryDTO> getCategories(String)
+ List<CategoryDTO> getCategories()
+ CategoryDTO getCategory(Integer)
+ List<CategoryTypeDTO> getTypeByCategoryId(Integer)
+ List<CategoryTypeDTO> getTypeByCategoryId(Integer,String)
  }
  class org.tecky.productservice.config.SeataRestTemplateConfiguration {
- Collection<RestTemplate> restTemplates
+ SeataFilter seataFilter()
+ SeataRestTemplateInterceptor seataRestTemplateInterceptor()
+ void init()
  }
  class org.tecky.warehouseservice.entities.ShipmentS2MInDetailEntity {
- Integer shippmentId
- String shippmentCompany
- int warehouserId
- String shippmentNum
- String progressStatus
- String directionType
- List<InDetailM2SShipmentEntity> inDetailM2SShipmentEntityList
  }
  class org.tecky.productservice.controller.WebControllerAdvice {
+ ResponseEntity<?> errorHandler(Exception)
  }
  class org.tecky.uuaservice.entities.compk.RoleAuthEntityEmbeddable {
- int scopeId
- int roleId
  }
  class org.tecky.common.dto.InventoryQtyRecordDTO {
- Integer inventoryId
- List<OnHandQtyRecordDTO> onHandQtyRecordDTOList
- List<AccQtyRecordDTO> accQtyRecordDTOList
- List<AvailQtyRecordDTO> availQtyRecordDTOList
  }
  class org.tecky.inventoryservice.nacosdiscovery.NacosDiscoveryConfiguration {
  }
  class org.tecky.common.dto.InventorySumDTO {
- Integer productId
- Integer onhandQty
- Integer availableQty
- Integer accountingQty
- List<InventoryDTO> inventories
  }
  class org.tecky.uuaservice.entities.compk.RoleAuthEntityPK {
- int roleId
- int scopeId
  }
  class org.tecky.couponservice.config.KafkaConfig {
+ {static} String GROUP_1
+ {static} String DEFAULT_SERVER
+ ProducerFactory<String,Object> producerFactory()
+ ConsumerFactory<String,String> consumerFactory()
+ ConcurrentKafkaListenerContainerFactory<String,String> kafkaListenerContainerFactory()
+ KafkaTemplate<String,Object> kafkaTemplate()
+ NewTopic defaultTopic()
  }
  interface org.tecky.uuaservice.mapper.RoleAuthEntityRepository {
+ List<RoleAuthEntity> findByRoleId(Integer)
+ List<RoleAuthEntity> findAllByRoleId(Integer)
+ void deleteByRoleIdAndScopeIdIn(Integer,List<Integer>)
  }
  class org.tecky.common.dto.PostOrderDTO {
- Integer uid
- Integer clientUid
- Integer couponId
- List<PostOrderProductDTO> postOrderProductDTOList
  }
  class org.tecky.common.dto.ProductDTO {
- Integer productId
- Integer groupId
- String colaValue
- String colbValue
  }
  class org.tecky.mvcwebcommon.filter.JWTFilter {
- String secret
- Pattern pattern
# void doFilterInternal(HttpServletRequest,HttpServletResponse,FilterChain)
}


org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.productservice.mapper.CategoryDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.OnHandQtyRecordDTO
java.io.Serializable <|.. org.tecky.common.dto.PropertyDTO
java.io.Serializable <|.. org.tecky.common.dto.PostWarehouseInShipmentDTO
org.tecky.inventoryservice.service.intf.InventoryService <|.. org.tecky.inventoryservice.service.impl.InventoryServiceImpl
org.tecky.common.api.productservice.ProductGroupAPI <|.. org.tecky.productservice.controller.ProductGroupController
java.io.Serializable <|.. org.tecky.common.dto.PostInventoryDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.orderservice.mapper.OrderS2MDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.InventoryDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.productservice.mapper.GroupDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.PostWarehouseInDTO
org.springframework.security.core.userdetails.UserDetailsService <|.. org.tecky.uuaservice.security.CustomUserDetailsService
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.InventorySecDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.AvailQtyRecordDTO
java.io.Serializable <|.. org.tecky.common.dto.PostAdminRegDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.ShipmentS2MInDetailEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.couponservice.mapper.CouponSecDetailEntityRepository
java.io.Serializable <|.. org.tecky.productservice.entities.TypeDetailEntity
org.tecky.mvcwebcommon.filter.Filter <|.. org.tecky.mvcwebcommon.filter.SeataFilter
java.io.Serializable <|.. org.tecky.common.dto.PostCouponDTO
java.io.Serializable <|.. org.tecky.common.dto.PostRoleDTO
org.tecky.common.api.productservice.CategoryAPI <|-- org.tecky.common.api.productservice.ProductServiceAPI
org.tecky.common.api.productservice.ProductGroupAPI <|-- org.tecky.common.api.productservice.ProductServiceAPI
org.tecky.common.api.productservice.TypeAPI <|-- org.tecky.common.api.productservice.ProductServiceAPI
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.ShipmentEntityRepository
org.tecky.orderservice.service.intf.IOrderService <|.. org.tecky.orderservice.service.impl.OrderServiceImpl
java.io.Serializable <|.. org.tecky.common.dto.PostClientLoginDTO
org.tecky.warehouseservice.service.intf.IWarehouseService <|.. org.tecky.warehouseservice.service.impl.WarehouseServiceImpl
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.couponservice.mapper.CouponRecordEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.orderservice.mapper.OrderEntityRepository
java.io.Serializable <|.. org.tecky.couponservice.entities.CouponRecordEntity
java.io.Serializable <|.. org.tecky.productservice.entities.GroupDetailEntity
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.couponservice.mapper.CouponTypeEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.AccountingDetailEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.InventoryDetailEntityRepository
org.tecky.common.api.inventoryservice.InventoryAPI <|-- org.tecky.graphqlservice.feign.FeignInventoryServiceAPI
java.io.Serializable <|.. org.tecky.couponservice.entities.CouponEntity
java.io.Serializable <|.. org.tecky.common.dto.PostProductDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.WarehouseEntityRepository
java.io.Serializable <|.. org.tecky.productservice.entities.comprimarykey.GroupEntityPK
org.tecky.common.api.productservice.TypeAPI <|.. org.tecky.productservice.controller.TypeController
java.io.Serializable <|.. org.tecky.couponservice.entities.CouponTypeEntity
java.io.Serializable <|.. org.tecky.warehouseservice.entities.WarehouseEntity
org.tecky.warehouseservice.service.intf.IShipmentService <|.. org.tecky.warehouseservice.service.impl.ShipmentServiceImpl
java.io.Serializable <|.. org.tecky.uuaservice.entities.ScopeEntity
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.InventorySecDetailO2MRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.AvailableDetailM2OEntityRepository
org.tecky.couponservice.service.intf.ICouponService <|.. org.tecky.couponservice.service.impl.CouponServiceImpl
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.UserEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.AvailableDetailEntityRepository
java.io.Serializable <|.. org.tecky.productservice.entities.CategoryDetailEntity
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.productservice.mapper.TypeDetailEntityRepository
org.tecky.storageservice.services.intf.IStorageService <|.. org.tecky.storageservice.services.impl.StorageServiceImpl
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.InDetailEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.StockEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.OutDetailEntityRepository
org.tecky.productservice.service.intf.IProductService <|.. org.tecky.productservice.service.impl.ProductServiceImpl
org.tecky.uuaservice.service.intf.IUserService <|.. org.tecky.uuaservice.service.impl.UserServiceImpl
java.io.Serializable <|.. org.tecky.productservice.entities.ProductDetailEntity
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.ScopeEntityRepository
java.io.Serializable <|.. org.tecky.productservice.entities.TypeEntity
java.io.Serializable <|.. org.tecky.common.dto.PostClientRegDTO
org.tecky.common.api.productservice.CategoryAPI <|.. org.tecky.productservice.controller.CategoryController
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.orderservice.mapper.OrderDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.SubPropertyDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.RoleEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.inventoryservice.mapper.OnhandDetailEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.productservice.mapper.ProductDetailEntityRepository
java.io.Serializable <|.. org.tecky.productservice.entities.comprimarykey.TypeEntityPK
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.couponservice.mapper.CouponDetailEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.PatchCouponDTO
java.io.Serializable <|.. org.tecky.common.dto.CategoryTypeDTO
java.io.Serializable <|.. org.tecky.common.dto.ProductGroupDTO
java.io.Serializable <|.. org.tecky.common.dto.PostGroupDTO
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.couponservice.mapper.CouponEntityRepository
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.warehouseservice.mapper.InDetailM2SShipmentEntityRepository
org.springframework.http.client.ClientHttpRequestInterceptor <|.. org.tecky.mvcwebcommon.interceptor.SeataRestTemplateInterceptor
org.tecky.common.api.productservice.ProductServiceAPI <|-- org.tecky.graphqlservice.feign.FeignProductServiceAPI
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.ClientSecUserEntityRepository
java.io.Serializable <|.. org.tecky.common.config.KafkaTopicConfig
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.productservice.mapper.TypeEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.PostWarehouseDTO
java.io.Serializable <|.. org.tecky.common.dto.CategoryDTO
java.io.Serializable <|.. org.tecky.couponservice.entities.CouponDetailEntity
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.orderservice.mapper.DetailM2SOrderEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.ClientDTO
java.io.Serializable <|.. org.tecky.common.dto.AccQtyRecordDTO
org.tecky.uuaservice.service.intf.IAdminService <|.. org.tecky.uuaservice.service.impl.AdminServiceImpl
java.io.Serializable <|.. org.tecky.common.dto.PostOrderProductDTO
java.io.Serializable <|.. org.tecky.couponservice.entities.CouponSecDetailEntity
org.tecky.common.api.inventoryservice.InventoryAPI <|-- org.tecky.common.api.inventoryservice.InventoryServiceAPI
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.RoleAuthS2OScopeEntityRepository
org.tecky.common.api.inventoryservice.InventoryAPI <|.. org.tecky.inventoryservice.controller.InventoryController
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.ClientEntityRepository
org.tecky.productservice.service.intf.ICategoryService <|.. org.tecky.productservice.service.impl.CategoryServiceImpl
java.io.Serializable <|.. org.tecky.uuaservice.entities.compk.RoleAuthEntityEmbeddable
java.io.Serializable <|.. org.tecky.common.dto.InventoryQtyRecordDTO
java.io.Serializable <|.. org.tecky.common.dto.InventorySumDTO
java.io.Serializable <|.. org.tecky.uuaservice.entities.compk.RoleAuthEntityPK
org.springframework.data.jpa.repository.JpaRepository <|-- org.tecky.uuaservice.mapper.RoleAuthEntityRepository
java.io.Serializable <|.. org.tecky.common.dto.PostOrderDTO
java.io.Serializable <|.. org.tecky.common.dto.ProductDTO
org.springframework.web.filter.OncePerRequestFilter <|-- org.tecky.mvcwebcommon.filter.JWTFilter
@enduml