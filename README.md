# CMS
基于ssm的学生成绩管理系统。管理员：admin 密码：123456
# 技术选型
layui + freemark + springMVC + mybatis


#说明：
与前端交互的接口的返回形式由layUI规定：
return StrUtil.RETURN_JONS_PRE_STR + list.size() 
       				+ StrUtil.RETURN_JONS_MID_STR
       				+ JSON.toJSONString(list) + StrUtil.RETURN_JONS_END_STR;