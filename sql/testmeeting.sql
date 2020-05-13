/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : testmeeting

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 13/05/2020 16:38:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon_cls` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, '/admin', 'AdminIndex', '首页', 'el-icon-s-home', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (2, '/admin/dashboard', 'DashboardAdmin', '运行情况', NULL, 'dashboard/admin/index', 1);
INSERT INTO `admin_menu` VALUES (3, '/admin', 'User', '用户管理', 'el-icon-user', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (4, '/admin', 'Content', '内容管理', 'el-icon-tickets', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (5, '/admin', 'System', '系统配置', 'el-icon-s-tools', 'AdminIndex', 0);
INSERT INTO `admin_menu` VALUES (6, '/admin/user/profile', 'Profile', '用户信息', NULL, 'user/UserProfile', 3);
INSERT INTO `admin_menu` VALUES (7, '/admin/user/role', 'Role', '角色配置', NULL, 'user/Role', 3);
INSERT INTO `admin_menu` VALUES (8, '/admin/content/book', 'BookManagement', '图书管理', NULL, 'content/BookManagement', 4);
INSERT INTO `admin_menu` VALUES (9, '/admin/content/room', 'RoomManagement', '教室管理', NULL, 'content/RoomManagement', 4);
INSERT INTO `admin_menu` VALUES (10, '/admin/content/article', 'ArticleManagement', '公告管理', NULL, 'content/ArticleManagement', 4);
INSERT INTO `admin_menu` VALUES (11, '/admin/content/meeting', 'MeetingManagement', '活动管理', NULL, 'content/MeetingManagement', 4);
INSERT INTO `admin_menu` VALUES (12, '/admin/content/department', 'DepartmentManagement', '组织管理', NULL, 'content/DepartmentManagement', 4);

-- ----------------------------
-- Table structure for admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_permission
-- ----------------------------
INSERT INTO `admin_permission` VALUES (1, 'users_management', '用户管理', '/api/admin/user');
INSERT INTO `admin_permission` VALUES (2, 'roles_management', '角色管理', '/api/admin/role');
INSERT INTO `admin_permission` VALUES (3, 'content_management', '内容管理', '/api/admin/content');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, 'sysAdmin', '系统管理员', 1);
INSERT INTO `admin_role` VALUES (2, 'contentManager', '内容管理员', 1);
INSERT INTO `admin_role` VALUES (3, 'visitor', '学生', 1);
INSERT INTO `admin_role` VALUES (9, 'test', '测试角色', 1);

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES (19, 4, 1);
INSERT INTO `admin_role_menu` VALUES (20, 4, 2);
INSERT INTO `admin_role_menu` VALUES (21, 3, 1);
INSERT INTO `admin_role_menu` VALUES (22, 3, 2);
INSERT INTO `admin_role_menu` VALUES (23, 9, 1);
INSERT INTO `admin_role_menu` VALUES (24, 9, 2);
INSERT INTO `admin_role_menu` VALUES (121, 1, 1);
INSERT INTO `admin_role_menu` VALUES (122, 1, 2);
INSERT INTO `admin_role_menu` VALUES (123, 1, 3);
INSERT INTO `admin_role_menu` VALUES (124, 1, 6);
INSERT INTO `admin_role_menu` VALUES (125, 1, 7);
INSERT INTO `admin_role_menu` VALUES (126, 1, 4);
INSERT INTO `admin_role_menu` VALUES (127, 1, 8);
INSERT INTO `admin_role_menu` VALUES (128, 1, 9);
INSERT INTO `admin_role_menu` VALUES (129, 1, 10);
INSERT INTO `admin_role_menu` VALUES (130, 1, 5);
INSERT INTO `admin_role_menu` VALUES (188, 2, 1);
INSERT INTO `admin_role_menu` VALUES (189, 2, 2);
INSERT INTO `admin_role_menu` VALUES (190, 2, 4);
INSERT INTO `admin_role_menu` VALUES (191, 2, 8);
INSERT INTO `admin_role_menu` VALUES (192, 2, 9);
INSERT INTO `admin_role_menu` VALUES (193, 2, 10);

-- ----------------------------
-- Table structure for admin_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permission`;
CREATE TABLE `admin_role_permission`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `rid` int(20) NULL DEFAULT NULL,
  `pid` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_role_permission_role_1`(`rid`) USING BTREE,
  INDEX `fk_role_permission_permission_1`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_permission
-- ----------------------------
INSERT INTO `admin_role_permission` VALUES (83, 5, 3);
INSERT INTO `admin_role_permission` VALUES (108, 1, 1);
INSERT INTO `admin_role_permission` VALUES (109, 1, 2);
INSERT INTO `admin_role_permission` VALUES (110, 1, 3);
INSERT INTO `admin_role_permission` VALUES (139, 2, 3);

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_operator_role_operator_1`(`uid`) USING BTREE,
  INDEX `fk_operator_role_role_1`(`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES (40, 24, 2);
INSERT INTO `admin_user_role` VALUES (63, 3, 2);
INSERT INTO `admin_user_role` VALUES (64, 1, 1);
INSERT INTO `admin_user_role` VALUES (67, 2, 3);
INSERT INTO `admin_user_role` VALUES (68, 110, 2);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `abs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_book_category_on_cid`(`cid`) USING BTREE,
  CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'https://i.loli.net/2019/04/10/5cadaa0d0759b.jpg', '且在人间', '余秀华', '2019-2-1', '湖南文艺出版社', '诗人余秀华中篇小说首次结集出版。\r\n\r\n        《且在人间》——以余秀华为生活原型，讲述一个残疾女人悲苦倔强、向死而生的故事。\r\n\r\n        女主人公周玉生活在乡村，患有“脑瘫”，她几乎被所有人漠视，甚至被整个社会抛弃，但是她渴望被当成一个普通的健康人,而不是带着怜悯或不屑，她只要求平等。爱情的缺 失，家庭的不幸，生活的种种际遇让周玉用诗歌的方式把 情感抒发出来，最终她用诗歌创作出了一个文学的世界，得到了人们的认可。', 2);
INSERT INTO `book` VALUES (2, 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', ' 2008-1', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……\r\n\r\n四光年外，“三体文明”正苦苦挣扎——三颗无规则运行的太阳主导下的百余次毁灭与重生逼迫他们逃离母星。而恰在此时。他们接收到了地球发来的信息。在运用超技术锁死地球人的基础科学之后。三体人庞大的宇宙舰队开始向地球进发……\r\n\r\n人类的末日悄然来临。', 2);
INSERT INTO `book` VALUES (32, 'https://i.loli.net/2019/04/10/5cada99bd8ca5.jpg', '叙事的虚构性', '[美] 海登·怀特 ', '2019-3', '南京大学出版社', '海登•怀特被誉为人类伟大的思想家之一。从1973年出版具有里程碑意义的专著《元史学》以来，怀特的作品对于历史学、文学研究、人类学、哲学、艺术史、电影传媒研究等将叙事学作为关注焦点的学科而言意义非凡。\n\n本书由罗伯特•多兰作序，他巧妙地将怀特重要但难得一见的文章汇集成册，研究探讨他关于历史书写和叙事的革命性理论。怀特的这些文章大多采用论文体，内容涉及多位思想家，探讨诸多主题，文笔犀利，语言优美。\n\n《叙事的虚构性》追溯怀特重要思想的演变轨迹，是历史编纂学者和学习者、历史理论和文学研究学者们的重要读物。', 3);
INSERT INTO `book` VALUES (35, 'https://i.loli.net/2019/04/10/5cada940e206a.jpg', '圣母', '[日]秋吉理香子 ', '2019-3', '新星出版社', '一起男童被害案搅得蓝出市人心惶惶。\n\n好不容易怀孕生产的保奈美抱紧年幼的孩子，立誓要不惜任何代价保护她。\n\n男人是在孩子出生后才成为父亲的，但女人，是从小生命来到体内的那一瞬间起，就是母亲了。患有不孕症的保奈美是经历过艰辛的治疗过程才终于有了孩子的，她不允许这起命案威胁到宝贵的孩子！\n\n母亲，就是要消除所有对子女的威胁，每一位母亲都应肩负这样的使命，这是神圣的天职！', 1);
INSERT INTO `book` VALUES (37, 'https://i.loli.net/2019/04/10/5cada8986e13a.jpg', '奢侈与逸乐', '[英]马克辛·伯格', '2019-3', '中国工人出版社', '本书探讨了十八世纪英国新式、时尚的消费品的发明、制造和购买。', 3);
INSERT INTO `book` VALUES (38, 'https://i.loli.net/2019/04/10/5cada8b8a3a17.jpg', '忧伤动物', '[德]莫妮卡·马龙 ', '2019-4', '漓江出版社', '“忧伤动物”(animal triste)这个词组取自一句最早可以追溯到亚里士多德时代的拉丁语名言，即“欢爱后，每个动物都忧伤不已”（Post coitum omne animal triste est）。无疑，这部冠以如此标题的小说让人有不祥的预感并暗示着宿命的思想。小说的女主人公是位近乎百岁的老人。在多年前有意斩断了与外界的一切联系之后，在她的后半生里，她唯一能做的就是或躺或坐在“印着鲜红、艳绿和深紫色的大花”、让人想起“食肉植物的花朵”的床单上，追忆几十年前她和自己...', 1);
INSERT INTO `book` VALUES (54, 'https://i.loli.net/2019/04/10/5cada9d9d23a6.jpg', '爱界', '[英] 费伊·韦尔登 ', '2019-3-1', '人民文学出版社', '去不去爱，爱的界限何在，一直是普拉克西丝的人生课题。\n\n年迈的她独自待在肮脏而昏暗的地下室里，想写回忆录，可她该写些什么呢？是写父母未婚同居生下了她，她还年幼天真无邪时，母女就遭父亲抛弃？还是写她曾经或是主动或是被动地成了未婚同居者、妻子、情人、母亲、后母？还是写她两年的牢狱生活？她想描绘二十世纪女性的众生相，想记录女性群体在情感、灵魂和思想方面所处的三重困境，想道出女性之间的大爱如何铸成姐妹之谊。', 3);
INSERT INTO `book` VALUES (55, 'https://i.loli.net/2019/04/10/5cada824c7119.jpg', '密室中的旅行', '[美] 保罗·奥斯特 ', '2019-3', '九州出版社', '一旦被抛进这个世界，我们就永远不会消失，即使造物者已经死去。\n\n.\n\n布兰克先生发现自己被囚禁在一个陌生的房间里，对过去的身份和经历一无所知。桌上有四叠六英寸厚的文稿，其中有一份未完待续的囚犯自述；还有一叠似曾相识的照片，照片中的人物将逐一登场。他续写了那个囚犯的故事，却发现自己正在经历的一切也早已被记录在文稿中……', 1);
INSERT INTO `book` VALUES (59, 'https://i.loli.net/2019/04/10/5cada87fd5c72.jpg', '基本穿搭', '[日]大山旬 ', '2019-3', '四川人民出版社', '对穿衣搭配感到不耐烦，认为时尚很麻烦，穿什么都可以或者对衣服有着自己的想法但不够自信，本书就是为这样的人而准备的穿衣指南。不需要追随瞬息万变的时尚潮流，也不需要烦恼色彩搭配，只要掌握最低限度的知识和备齐常规单品，谁都能完成清爽得体的 80分搭配。', 4);
INSERT INTO `book` VALUES (60, 'https://i.loli.net/2019/04/10/5cada976927da.jpg', '冒牌人生', '陈思安', '2019-4', '四川文艺出版社', '《冒牌人生》收录了十篇短篇小说。十个故事分别以城市中的怪人为主角，他们默默无闻地生存在城市主流生活的边缘地带：或是等待手术的性别认同障碍者，或是武艺高强而深藏不露的夜市摊主，或是卧底追凶的底层保安，或是甘于...', 1);
INSERT INTO `book` VALUES (61, 'https://i.loli.net/2019/04/10/5cada9202d970.jpg', '战争哀歌', '[越]保宁 ', '2019-4', '湖南文艺出版社', '《战争哀歌》超越了战争，战争是它的背景，它的内核是关于逝去的青春，关于美和伤痛！\n\n一场突如其来的战争打碎了阿坚和阿芳这对年轻情侣的生活，在血肉横飞的战争中，主人公阿坚成了幸存者，但战争带来的伤痛还远远没有平息。那些经历仍旧萦绕在阿坚的生活之中，被战争毁灭的不仅 仅是阿坚， 阿芳也遭遇了难以想象的梦魇。时间越长，阿坚越觉得自己不是活着，而是被困在这人世间。', 1);
INSERT INTO `book` VALUES (62, 'https://i.loli.net/2019/04/10/5cada9c852298.jpg', '胡椒的全球史', '[美] 玛乔丽·谢弗 ', '2019-3', '上海三联出版社', '看似不起眼的胡椒，却是家家餐桌必备。在中世纪时，更是欧洲达官显贵们的最爱、财富与地位的象征。黑胡椒原产于印度，距离欧洲各港口有十万八千里之远，取之向来不易。商人们对其供应来源不遗余力的追寻，成为世界史上一股重要的推动力量，促成全球贸易的兴起，重新划定了世界经济版图。', 2);
INSERT INTO `book` VALUES (63, 'https://i.loli.net/2019/04/10/5cada962c287c.jpg', '与病对话', '胡冰霜', '2019-3-31', '北京联合出版公司', '一部融合科普性与趣味性、兼具心理学与哲学意味的医学散文。\n\n一位满怀仁心的资深医者对几十年行医生涯的回望与省思。\n\n全书以真实的病例和鲜活的故事贯穿始终，作者从一位全科医生、心理学者的视角观察、解读疾病与患者身心之关系，厘清大众对诸多常见疾病的误解...', 1);
INSERT INTO `book` VALUES (64, 'https://i.loli.net/2019/04/10/5cada858e6019.jpg', '上帝笑了99次', '[英]彼得·凯弗', '2019-2', '北京联合出版公司', '一只美洲羊驼会坠入爱河吗？机器人能变成人吗？怎样才能不赢得公主青睐？人类一思考，上帝就发笑。在99个奇妙、怪诞、滑稽的问题背后，其实是99个烧脑的哲学、道德、法律领域的经典悖论，也是99道极富挑战性的大思考测试。本书内容覆盖了大多数常见哲学话题，包括形而上学、逻辑学、伦理学、语言哲学、政治哲学、自我认知、人际关系、美学、存在主义等，还配有20多幅漫画插图。在锻炼思维之外，本书也能帮我们建立个性化的哲学知识体系。', 3);
INSERT INTO `book` VALUES (65, 'https://i.loli.net/2019/04/10/5cada8e1aa892.jpg', '互联网算法', '[美] 菲斯曼等 ', '2019-4', '江西人民出版社', '只要你租过房子、上网买过东西、自己经营过企业，那么你就处在商业变革的前线。在这场变革中，亚马逊、谷歌、优步等不同以往的企业取得了史无前例的成功，而促成这场变革的不只是科技进步，还有经济学思想。\n\n在这本趣味横生的书中，我们会看到，经济思想的革命远比科技革命更宏大。从谷歌广告的算法，到网上购物规避欺诈，都要依靠经济学家建立的经济模型，甚至连互联网公司...', 6);
INSERT INTO `book` VALUES (66, 'https://i.loli.net/2019/04/10/5cada9ec514c9.jpg', '七侯笔录', '马伯庸', '2019-4-15', '湖南文艺出版社', '一个关于文化的离奇故事，一段关于文人的壮丽传说。\n\n几千年来，每一位风华绝代的文人墨客辞世之时，都会让自己的灵魂寄寓在一管毛笔之中。他们身躯虽去，才华永存，这些伟大的精神凝为性情不一的笔灵，深藏于世间，只为一句“不教天下才情付诸东流”的誓言。其中最伟大的七位古人，他们所凝聚的七管笔灵，被称为“管城七侯”。\n\n一位不学无术的现代少年，无意中邂逅了李白的青莲笔，命运就此与千年之前的诗仙交织一处，并为他开启了一个叫作笔冢的神秘世界。', 3);
INSERT INTO `book` VALUES (67, 'https://i.loli.net/2019/04/10/5cada9870c2ab.jpg', '中心与边缘', '[美] 希尔斯', '2019-3', '译林出版社', '美国著名社会学家爱德华·希尔斯的主要研究成果包括他对“克里斯玛”、“中心”和“边缘”等概念的解释，以及他对“大众社会”一词的修正，这些研究对分析政治和文化领导力以及社会凝聚力具有重要价值。本书对希尔斯数十载社会理论研究进行了全面而详细的总结，为解释与探究当代社会的结构与变化提供了极具科学性的参考依据。', 3);
INSERT INTO `book` VALUES (68, 'https://i.loli.net/2019/04/10/5cad643643d4c.jpg', '水浒群星闪耀时', '李黎', '2019-4', '上海文艺出版社', '本书以众所周知的梁山英雄为写作对象，重点书写其上山后、招安前的日常生活，涉及他们的喜怒哀乐、同类中人、乡愁怀旧、未来憧憬、命运追问等。书中涉及宋江、武松、鲁智深、李俊、燕青等等耳熟能详的人物而显得有些“改编”与水浒研究的意味，但鉴于所有人物皆为虚构，本书稿的内容是虚构之上的虚构，旨在宏大叙事的语境下突出个人的细微之处和命运感。', 1);
INSERT INTO `book` VALUES (69, 'https://i.loli.net/2019/04/10/5cad63931ce27.jpg', '谋杀狄更斯', '[美] 丹·西蒙斯 ', '2019-4', '上海文艺出版社', '“狄更斯的那场意外灾难发生在1865年6月9日，那列搭载他的成功、平静、理智、手稿与情妇的火车一路飞驰，迎向铁道上的裂隙，突然触目惊心地坠落了。”', 1);
INSERT INTO `book` VALUES (70, 'http://localhost:8443/api/file/gx7erx.jpg', '像艺术家一样思考', '[英] 威尔·贡培兹', '2019-4', '湖南美术出版社', '归纳成就艺术大师的 10 个关键词\n\n揭示大师们的创作秘辛\n\n凝聚 BBC 艺术频道主编威尔·贡培兹职业生涯的所见、所知、所想\n\n·\n\n威尔·贡培兹是你能遇到的最好的老师\n\n——《卫报》', 3);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '文学');
INSERT INTO `category` VALUES (2, '流行');
INSERT INTO `category` VALUES (3, '文化');
INSERT INTO `category` VALUES (4, '生活');
INSERT INTO `category` VALUES (5, '经管');
INSERT INTO `category` VALUES (6, '科技');

-- ----------------------------
-- Table structure for class_room
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room`  (
  `room_id` bigint(20) NOT NULL,
  `capacity` int(11) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `room_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `room_num` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_room
-- ----------------------------
INSERT INTO `class_room` VALUES (3, 100, '用于系统测试', '测试一号', 1, 1, '测试楼2楼中');
INSERT INTO `class_room` VALUES (4, 50, '用于测试的教室二号机', '测试教室二号', 0, 0, '测试楼1楼北');
INSERT INTO `class_room` VALUES (5, 200, '用于测试的大号房间', '测试究极房间', 3, 0, '测试楼5楼东');
INSERT INTO `class_room` VALUES (6, 100, '物联网工程专用实验室', '物联网工程实验室', 21, 0, '11号楼行政区611号');
INSERT INTO `class_room` VALUES (7, 200, '7号楼的大教室，多媒体，无监控', '07103教室', 34, 0, '七号楼一楼东');
INSERT INTO `class_room` VALUES (8, 50, '一号楼 010002J', '一号楼 010002J', 102, 0, '一楼东侧');
INSERT INTO `class_room` VALUES (10, 200, '11号楼2楼多媒体教室，有监控', '11207教室', 110207, 0, '11号楼教学区2楼');
INSERT INTO `class_room` VALUES (11, 150, '9号楼多媒体教室，有监控', '09203教室', 9203, 0, '9号教学楼教学区2楼');
INSERT INTO `class_room` VALUES (12, 150, '7号楼三楼多媒体教室，无监控', '07302教室', 7302, -1, '7号教学楼3楼东');
INSERT INTO `class_room` VALUES (13, 50, '10号楼一楼教室', '10101教室', 10101, 0, '10号楼一楼西');
INSERT INTO `class_room` VALUES (14, 50, 'Android创新实验室', 'Android实验室', 11711, 0, '主楼办公区七楼中');
INSERT INTO `class_room` VALUES (15, 100, '用于实验的多媒体教室', '特种教室1', 20000, 0, '11号楼11层');
INSERT INTO `class_room` VALUES (16, 100, '测试用', '特种教室2', 200001, 0, '主楼11层');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `department_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (0, '默认权限组');
INSERT INTO `department` VALUES (1, '管理组');
INSERT INTO `department` VALUES (2, '16070942');
INSERT INTO `department` VALUES (4, '测试组');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (50);

-- ----------------------------
-- Table structure for jotter_article
-- ----------------------------
DROP TABLE IF EXISTS `jotter_article`;
CREATE TABLE `jotter_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_content_html` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `article_content_md` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `article_abstract` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `article_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jotter_article
-- ----------------------------
INSERT INTO `jotter_article` VALUES (14, '系统使用说明', '<h1><a id=\"ICRS__0\"></a>ICRS 使用说明</h1>\n<h2><a id=\"_1\"></a>测试测试</h2>\n', '# ICRS 使用说明\n## 测试测试', NULL, NULL, NULL);
INSERT INTO `jotter_article` VALUES (15, 'ICRS-使用说明书', '<h1><a id=\"ICRS_0\"></a>ICRS-使用说明书</h1>\n<p><img src=\"https://img.shields.io/github/license/Antabot/White-Jotter\" alt=\"license\" /><br />\n<img src=\"https://img.shields.io/github/v/release/Antabot/White-Jotter\" alt=\"release\" /><br />\n<img src=\"https://www.travis-ci.org/Antabot/White-Jotter.svg?branch=master\" alt=\"Build Status\" /></p>\n<h2><a id=\"_7\"></a>项目简介</h2>\n<pre><code class=\"lang-text\">    这是一个前后端分离的教室预约和查看系统项目，主要采用Vue.js+SpringBoot 技术栈开发\n</code></pre>\n<h2><a id=\"_12\"></a>前端项目地址</h2>\n<h2><a id=\"_14\"></a>效果截图</h2>\n<p><img src=\"https://i.loli.net/2020/05/02/jKXg6acDpS8MP4R.png\" alt=\"image.png\" /></p>\n', '# ICRS-使用说明书\n\n\n![license](https://img.shields.io/github/license/Antabot/White-Jotter)\n![release](https://img.shields.io/github/v/release/Antabot/White-Jotter)\n![Build Status](https://www.travis-ci.org/Antabot/White-Jotter.svg?branch=master)\n\n## 项目简介\n```text\n    这是一个前后端分离的教室预约和查看系统项目，主要采用Vue.js+SpringBoot 技术栈开发\n```\n\n## 前端项目地址\n\n## 效果截图\n![image.png](https://i.loli.net/2020/05/02/jKXg6acDpS8MP4R.png)', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `meeting_id` bigint(20) NOT NULL,
  `canceled_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `canceled_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `meeting_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number_of_participants` int(11) NOT NULL,
  `reservation_is_tid` int(11) NOT NULL,
  `reservation_time` datetime(0) NULL DEFAULT NULL,
  `room_id` int(11) NOT NULL,
  `room_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`meeting_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, NULL, NULL, '测试测试', '2020-04-24 20:42:13', '测试', 50, 0, '2020-04-29 20:44:00', 1, '11207教室', '2020-04-23 20:41:32', -1, 'admin');
INSERT INTO `meeting` VALUES (2, NULL, NULL, '测试测试', '2020-04-21 20:51:12', '测试2', 100, 8, '2020-04-08 20:51:38', 2, '11207教室', '2020-04-20 20:51:07', -1, 'admin');
INSERT INTO `meeting` VALUES (18, NULL, '2020-04-30 12:51:46', NULL, '2020-04-30 02:27:22', NULL, 0, 8, '2020-04-30 02:27:22', 4, '测试教室二号', '2020-04-30 02:27:22', -1, 'admin');
INSERT INTO `meeting` VALUES (19, NULL, NULL, NULL, '2020-04-30 02:37:06', NULL, 0, 8, '2020-04-30 02:37:06', 4, '测试教室二号', '2020-04-30 02:37:06', -1, 'admin');
INSERT INTO `meeting` VALUES (20, NULL, NULL, NULL, '2020-04-30 02:40:28', NULL, 0, 8, '2020-04-30 02:40:28', 3, '测试一号', '2020-04-30 02:40:28', -1, 'admin');
INSERT INTO `meeting` VALUES (21, NULL, NULL, '1212', '2020-04-21 16:00:00', '1111d', 12, 8, '2020-04-30 02:42:00', 3, '测试一号', '2020-04-14 16:00:00', -1, '1');
INSERT INTO `meeting` VALUES (22, NULL, '2020-05-02 10:04:21', '等等等', '2020-05-15 16:00:00', '代表会议', 13, 8, '2019-12-29 09:21:11', 3, '测试一号', '2019-05-15 11:00:00', 0, 'admin');
INSERT INTO `meeting` VALUES (23, NULL, NULL, '视听会议', '2019-05-08 12:00:00', '试听会议', 57, 8, '2019-12-29 11:37:52', 7, '07103教室', '2019-05-08 10:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (24, NULL, NULL, '定点迭代', '2019-12-28 16:00:00', '111', 12, 8, '2019-12-29 11:51:15', 3, '测试一号', '2019-12-28 16:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (25, NULL, NULL, '点对点', '2019-12-29 04:00:00', '东方饭店', 40, 8, '2019-12-29 11:52:58', 14, 'Android实验室', '2019-12-29 06:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (26, NULL, NULL, '1111', '2019-12-29 11:55:25', '1111', 24, 8, '2019-12-29 11:55:39', 3, '测试一号', '2019-12-28 16:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (27, NULL, NULL, '1222', '2019-12-28 16:00:00', '111', 134, 8, '2019-12-29 11:56:51', 11, '09203教室', '2019-12-29 11:56:47', -1, 'admin');
INSERT INTO `meeting` VALUES (28, NULL, NULL, '全都是', '2020-04-30 12:03:51', '大多数是', 12, 8, '2020-04-30 12:04:12', 14, 'Android实验室', '2020-05-01 04:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (29, NULL, NULL, '哒哒哒哒哒哒多', '2020-05-02 06:00:00', '测试测试', 12, 8, '2020-05-01 16:14:58', 3, '测试一号', '2020-05-02 04:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (30, NULL, NULL, '前期强调的', '2020-05-02 08:00:00', '核动力', 35, 8, '2020-05-02 02:15:28', 7, '07103教室', '2020-05-14 07:00:00', 2, NULL);
INSERT INTO `meeting` VALUES (31, NULL, NULL, '核动力', '2020-05-02 09:00:00', '核动力', 40, 8, '2020-05-02 02:18:51', 7, '07103教室', '2020-05-02 07:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (32, NULL, '2020-05-02 10:09:56', '111111', '2020-05-04 16:00:00', 'cece', 13, 8, '2020-05-02 10:09:44', 3, '测试一号', '2020-05-02 10:09:36', -1, 'admin');
INSERT INTO `meeting` VALUES (33, NULL, '2020-05-02 10:13:40', '等等等', '2020-05-04 16:00:00', '测试测试', 12, 8, '2020-05-02 10:13:16', 7, '07103教室', '2020-05-02 10:12:59', -1, 'admin');
INSERT INTO `meeting` VALUES (34, '打的动', '2020-05-02 10:18:30', '1111', '2020-05-06 16:00:00', '1111', 14, 8, '2020-05-02 10:18:16', 7, '07103教室', '2020-05-02 10:18:07', -1, 'admin');
INSERT INTO `meeting` VALUES (35, NULL, NULL, '大家要毕业了', '2020-05-02 15:00:00', '测试测试', 30, 8, '2020-05-02 11:24:49', 7, '07103教室', '2020-05-02 11:24:11', -1, 'admin');
INSERT INTO `meeting` VALUES (36, NULL, NULL, 'ddd', '2020-05-04 16:00:00', 'ddd', 1, 8, '2020-05-02 13:05:14', 3, '测试一号', '2020-04-27 16:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (37, NULL, NULL, '11', '2020-04-26 16:00:00', '111', 1, 8, '2020-05-02 13:06:29', 3, '测试一号', '2020-04-27 16:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (38, NULL, NULL, '88', '2020-05-04 16:00:00', '777', 1, 8, '2020-05-02 13:14:20', 3, '测试一号', '2020-04-29 13:13:41', -1, 'admin');
INSERT INTO `meeting` VALUES (39, NULL, NULL, '111', '2020-04-30 16:00:00', '111', 1, 8, '2020-05-02 13:17:49', 3, '测试一号', '2020-05-03 13:17:28', -1, 'admin');
INSERT INTO `meeting` VALUES (41, NULL, NULL, '测试', '2020-05-03 05:00:00', '测试赛', 12, 8, '2020-05-02 14:03:52', 7, '07103教室', '2020-05-03 01:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (42, NULL, NULL, '等待', '2020-05-05 06:06:19', '测试测试', 12, 8, '2020-05-03 03:21:27', 3, '测试一号', '2020-05-05 04:06:01', -1, 'admin');
INSERT INTO `meeting` VALUES (43, NULL, NULL, '活动教学', '2020-05-09 08:00:00', '教学课程', 10, 8, '2020-05-09 03:33:57', 3, '测试一号', '2020-05-09 07:00:00', -1, '1607094299');
INSERT INTO `meeting` VALUES (44, '临时取消', '2020-05-09 03:36:26', '活动教学', '2020-05-21 08:00:00', '教学课程-下次', 10, 8, '2020-05-09 03:34:22', 7, '07103教室', '2020-05-21 07:00:00', 0, '1607094299');
INSERT INTO `meeting` VALUES (45, NULL, NULL, '踩踩踩从', '2020-05-10 09:00:00', '侧测试', 12, 8, '2020-05-10 02:47:14', 3, '测试一号', '2020-05-10 03:46:55', -1, 'admin');
INSERT INTO `meeting` VALUES (46, '无效', '2020-05-10 12:30:46', '储存池', '2020-05-10 13:00:00', '测试测试', 12, 8, '2020-05-10 10:58:53', 3, '测试一号', '2020-05-10 11:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (47, NULL, NULL, '快看看吧', '2020-05-10 14:00:00', '就KIKI', 30, 8, '2020-05-10 12:31:49', 3, '测试一号', '2020-05-10 12:33:20', -1, 'admin');
INSERT INTO `meeting` VALUES (48, NULL, NULL, '的点点滴滴', '2020-05-11 06:00:00', '发的发的', 58, 8, '2020-05-10 12:48:22', 3, '测试一号', '2020-05-11 04:00:00', -1, 'admin');
INSERT INTO `meeting` VALUES (49, '取消', '2020-05-10 12:49:16', '的点点滴滴', '2020-05-10 15:50:00', '发的发的发发发', 58, 8, '2020-05-10 12:48:51', 3, '测试一号', '2020-05-10 15:00:00', -1, 'admin');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rfidid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `department_id` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `student_id_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, NULL, 0, NULL, 'a3fdb038a550c69f991794e3d708d4c4', NULL, 0, 0, '113', NULL, '3ZIHQUh1Luz8XFQWdxZhfw==', b'1');
INSERT INTO `student` VALUES (8, NULL, 0, '111', 'ad5f878eaa0281f3032e69ccdb31fa0f', '11', 0, 0, '111', '111', 'QOxH3ZXMBLkQHO3Lc6p+aA==', b'1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  `rfidid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '35b9529f89cfb9b848060ca576237e17', '8O+vDNr2sI3N82BI31fu1A==', '管理员', '12312312312', 'evan_nightly@163.com', 1, 1, '1', '216447');
INSERT INTO `user` VALUES (2, 'test', '85087738b6c1e1d212683bfafc163853', 'JBba3j5qRykIPJQYTNNH9A==', '测试', '12312312312', '123@123.com', 1, 1, '2', '160216185');
INSERT INTO `user` VALUES (3, 'editor', '8583a2d965d6159edbf65c82d871fa3e', 'MZTe7Qwf9QgXBXrZzTIqJQ==', '编辑', NULL, NULL, 1, 1, '3', NULL);
INSERT INTO `user` VALUES (110, '160704200', 'd95e41ae64ddb80788ed39b3459d5792', 'hG81DnCiSPT52Xy99ogQzg==', '金浩', '18211111111', 'jinhao.jh@foxmail.com', 1, 0, '4', NULL);
INSERT INTO `user` VALUES (111, '1607094299', '07fe1e0b2f8f48ccd9248e2e743cf83e', 'JQLFXP3Ho9HwAomGGrq7LQ==', 'mia', '111111', 'admin@shencangblue.com', 1, 0, '5', NULL);

SET FOREIGN_KEY_CHECKS = 1;
