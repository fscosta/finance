<#import "spring.ftl" as spring />

<#macro sortingRule attributeOptions ascendingOptions sort=''>
	<div>
		<@spring.formSingleSelect path="sort.attributeType.id" options=attributeOptions />
		<@spring.formSingleSelect path="sort.ascending" options=ascendingOptions />
	</div>
</#macro>

<#macro filter attributeOptions operatorOptions filter=''>
	<div>
		<@spring.formSingleSelect path="filter.attributeType.id" options=attributeOptions />
		<@spring.formSingleSelect path="filter.operator" options=operatorOptions />
		<@spring.formInput path="filter.threshold" />
	</div>
</#macro>
