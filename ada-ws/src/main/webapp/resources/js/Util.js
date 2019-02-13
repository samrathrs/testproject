var com = com || {};

if (!com.transerainc) {
    com.transerainc = {};
}
if (!com.transerainc.adaws) {
    com.transerainc.adaws = {};
}

com.transerainc.adaws.Util = function() {

    // private member variables and methods

    // public member variables and methods
    return {

        sendRequest : function(url, method, data, resultTargetId, targetId) {

            $('#' + targetId).addClass('btn-disabled');
            $('#' + targetId).button('loading');

            var request = $.ajax({
                url : url + "?ts=" + new Date().getTime(),
                type : method,
                data : data,
                dataType : "json"
            });

            request.done(function(msg) {
                // $('#'+resultDiv).removeClass('alert-success');
                $('#' + resultTargetId).removeClass('alert-danger');
                $('#' + resultTargetId).addClass('alert-success in');
                $('#' + resultTargetId).html('Submitted successfully for agent session - ' + targetId);
                $('#' + resultTargetId).show();
                
                $('#' + targetId).html('LoggedOut');
        		$('#' + targetId).button('refresh');
                // alert(msg + '#' + resultTargetId);
                // $('#' + resultTargetId).fadeOut(10000);
            });

            request.fail(function(jqXHR, textStatus) {
                $('#' + resultTargetId).removeClass('alert-success');
                $('#' + resultTargetId).addClass('alert-danger in');
                $('#' + resultTargetId).html('Failed to submit. reason is ' + textStatus);
                $("#" + resultTargetId).html(textStatus);
                $('#' + resultTargetId).show();
                
                $('#' + targetId).html('LogOut');
        		$('#' + targetId).button('refresh');
                // alert("Request failed: " + textStatus);
            });

            // $('#' + resultTargetId).show();
            // $('#' + resultTargetId).fadeOut(5000);
        },

        exportData : function() {

            var data = new Object();
            data.queryId = $('#queryId').val();
            data.enterpriseId = $('#enterpriseId').val();
            data.startTime = $('#startDate').val();
            data.endTime = $('#endDate').val();

            this.sendRequest('export-data', 'POST', data, 'result-msg-div');
        },
        
        logoutAgent : function(agent) {
    		/*var request = $.ajax({
                url : "logoutAgent" + "?ts=" + new Date().getTime(),
                type : 'POST',
                data : agent,
                dataType : "json"
            });*/
    		
    		this.sendRequest('logoutAgent', 'POST', agent, 'result-msg-div');
    	}
    };

}();
