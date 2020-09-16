# forsage 合约接入文档
- 一般流程：
  -    创建合约(平台)
  -    注册(用户)
  -    激活等级(用户)
## 合约准备
* [创建合约](#创建合约)
## 合约接口执行
* [注册](#注册)：registrationExt
* [激活等级](#激活等级)：buyNewLevel
## 合约信息查询
* [查找X3上级](#查找X3上级)：findFreeX3Referrer
* [查找X6上级](#查找X6上级)：findFreeX6Referrer
* [用户ID查询地址](#用户ID查询地址)：idToAddress 
* [用户是否已注册](#用户是否已注册)：isUserExists
* [最高等级](#最高等级)：LAST_LEVEL
* [最大用户ID](#最大用户ID):LastUserId
* [等级投资价格](#等级投资价格)：LevelPrice
* [创始人](#创始人)：owner
* [用户信息](#用户信息)：users
* [用户是否激活X3等级](#用户是否激活X3等级)：usersActiveX3Levels
* [用户是否激活X6等级](#用户是否激活X6等级)：usersActiveX6Levels
* [用户X3信息](#用户X3信息)：usersX3Matrix
* [用户X6信息](#用户X6信息)：usersX6Matrix
    
### 创建合约
    
#### 描述
    创建合约，并传入创始人owner,创建合约者需扣除0.025ETH
    创始人开通所有等级的X3 X6矩阵
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|ownerAddress|address|创始人地址||
#### 返回
    constructor(address ownerAddress) public {}
    
    
### 注册
    
#### 描述
    加入矩阵并激活等级1,并同时开启 X3(需要0.025) x6(需要0.025)，执行时传入金额必须为0.05ETH
   
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|referrerAddress|address|推荐人地址||
#### 返回

-   注册1：传入地址
```    
    直接转账到合约地址，默认邀请者为创始人，data可传入推荐地址
```  
    
-   注册2：传入地址
```    
    function registrationExt(address referrerAddress) external payable {}
```       
    
### 激活等级
    
#### 描述
    开通指定等级，需要先查询该等级的价格，执行时传入金额必须为等级对应价格的ETH
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|matrix|uint|矩阵 1：X3 2:X6||
|level|uint|等级 1...12|
#### 返回
    function buyNewLevel(uint8 matrix, uint8 level) external payable {}
    
### 查找X3上级
    
#### 描述
    根据用户当前等级查询上级
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|userAddress|userAddress|查询的用户地址||
|level|uint|等级 1...12|
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|上级地址||

#### 返回
    function findFreeX3Referrer(address userAddress, uint8 level) public view returns(address) {}
    
### 查找X6上级
    
#### 描述
    根据用户当前等级查询上级
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|userAddress|userAddress|查询的用户地址||
|level|uint|等级 1...12|
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|上级地址||

#### 返回
    function findFreeX6Referrer(address userAddress, uint8 level) public view returns(address) {}
    
    
### 用户ID查询地址
    
#### 描述
    根据userId查询对应地址
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint|用户ID||
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|地址||

#### 返回
    mapping(uint => address) public idToAddress;//根据用户ID查询地址
    
### 地址是否已注册
    
#### 描述
    根据userId查询对应地址
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|user|address|地址||
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|bool|是否已注册 0：否 1：是||

#### 返回
    function isUserExists(address user) public view returns (bool) {}
    
### 最高等级
    
#### 描述
    根据矩阵的最高等级
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint8|等级 ||

#### 返回
    uint8 public constant LAST_LEVEL = 12;//初始化的级别数量，当前十二级
    
    
### 最大用户ID(用户数量)
    
#### 描述
    查询最新注册的用户ID，该值可作为最大用户数量
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint|最大用户ID/用户数量 ||

#### 返回
    uint public lastUserId = 2;//当前最大用户ID
    
    
### 等级投资价格
    
#### 描述
    查询等级投资价格
    
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
||uint8|级别/用户数量 ||

#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint|价格 ||

#### 返回
    mapping(uint8 => uint) public levelPrice;//各级别的价格
    
    
### 创始人
    
#### 描述
    查询创始人
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|创始人地址 ||

#### 返回
    address public owner; //创始人
    
    
### 用户信息
 
#### 描述
    查询创始人
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|地址 ||
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|id|unit|用户ID ||
|referrer|address|推荐人 ||
|partnersCount|unit|邀请数量 ||
        

#### 返回
    mapping(address => User) public users;//根据地址查询对应的用户信息
    struct User {
        uint id;//用户ID
        address referrer;//邀请人
        uint partnersCount;//邀请数量
    }
    
 
### 用户X3等级是否激活
 
#### 描述
    根据等级查询矩阵X3的该等级是否已激活
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint8|等级 ||
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|bool|是否激活 0：未激活 1：激活 ||

    mapping(uint8 => bool) activeX3Levels;//X3的各个级别是否开通
            
### 用户X6等级是否激活
 
#### 描述
    根据等级查询矩阵X6的该等级是否已激活
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|uint8|等级 ||
#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|bool|是否激活 0：未激活 1：激活 ||

    mapping(uint8 => bool) activeX6Levels;//X6的各个级别是否开通
    
    
### 用户X3信息
 
#### 描述
    根据用户地址，级别查询用户矩阵X3的信息
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|用户地址 ||
|——|uint8|等级 ||

#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|currentReferrer|address|当前用户上级||
|referrals|address[]|当前用户下级集合||
|blocked|bool|是否已循环过 ||
|reinvestCount|uint|循环次数||

    mapping(address => User) public users;//根据地址查询对应的用户信息
    struct User {
        mapping(uint8 => X3) x3Matrix;//各个级别的x3信息
    }
    struct X3 {
        address currentReferrer;//当前用户上级
        address[] referrals;//当前用户下级的集合
        bool blocked;//是否阻塞，是否满员
        uint reinvestCount;//复投次数
    }
        
### 用户X6信息
 
#### 描述
    根据用户地址，级别查询用户矩阵X6的信息
#### 输入
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|——|address|用户地址 ||
|——|uint8|等级 ||

#### 返回
|参数|类型|描述|示例|
|:----|:----|:----|:----|
|currentReferrer|address|当前用户上级||
|firstLevelReferrals|address[]|当前用户下级第一阶梯的集合||
|secondLevelReferrals|address[]|当前用户下级第二阶梯的集合||
|blocked|bool|是否已循环过 ||
|reinvestCount|uint|循环次数||
|closedPart|address|下级中第一阶梯中触发循环的地址||

    mapping(address => User) public users;//根据地址查询对应的用户信息
    struct User {
        mapping(uint8 => X6) x6Matrix;//各个级别的x6信息
    }
    struct X6 {
        address currentReferrer;//当前用户上级
        address[] firstLevelReferrals;//第一阶梯的集合
        address[] secondLevelReferrals;//第二阶梯的集合
        bool blocked;//是否阻塞，是否满员
        uint reinvestCount;//复投次数
    
        address closedPart;//?
    }