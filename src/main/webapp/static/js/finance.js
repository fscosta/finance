$(document).ready( function() {
	
	$('#addSort').click( function() {
		ruleComponent = $('#ruleComponent').html();
		$('#sortingRules').append(ruleComponent);
	});
	
	$('#addFilter').click( function() {
		filterComponent = $('#filterComponent').html();
		$('#filters').append(filterComponent);
	});
	
});

