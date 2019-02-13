var jsMessages = [];

var com = com || {};

if (!com.transerainc) {
  com.transerainc = {};
}

if (!com.transerainc.ada) {
  com.transerainc.ada = {};
}

com.transerainc.ada.Page = function() {
  // private member variables and methods

  var iCheckNature = function() {
    $('input').iCheck({
      checkboxClass : 'icheckbox_flat-blue',
      radioClass : 'iradio_flat-blue'
    // increaseArea : '20%' // optional
    });
  };

  var toggleSuccessAlerts = function() {
    if ($('.alert-success') != null) {
      $('.alert-success').alert();
      $('.alert-success').fadeTo(3000, 0.9).slideUp(500, function() {
        $('.alert-success').alert('close');
      });
    }
  };

  var toggleMenu = function(id) {
    $('#header-menu>li.active').removeClass('active');
    $('#' + id).addClass('active');
  }

  var addCustomValidations = function() {
    jQuery.validator.addMethod("alphanumeric", function(value, element) {
      return this.optional(element) || /^[A-Za-z0-9_ ()-]*$/.test(value);
    }, jsMessages['message.validation.alpha.numeric']);

    jQuery.validator.addMethod("startsWithSpace", function(value, element) {
      return this.optional(element) || /^[A-Za-z0-9_()-]+[A-Za-z0-9_ ()-]*$/.test(value);
    }, jsMessages['message.validation.start.with.space']);

    jQuery.validator.addMethod("hasDoubleSpace", function(value, element) {
      value = value === null ? '' : value;
      return this.optional(element) || /^[A-Za-z0-9_()-]+( [A-Za-z0-9_()-]+)*$/.test(value.trim());
    }, jsMessages['message.validation.consecutive.space']);
  };

  var createTable = function(options) {
    if (!options) {
      return;
    }
    var tableId = options.tableId;
    var hasRadio = options.hasRadio;
    var buttons = options.buttons;
    var rowKey = options.rowKey;
    var formId = options.formId;
    var hasActions = options.hasActions;
    var actionsCol = options.actionsCol;
    var actionMap = options.actionMap;
    var entityListType = options.entityListType;
    var orderCol = 0;

    // create datatable
    var dtTable = $('#' + tableId).dataTable({
      order : [ [ orderCol, "asc" ] ], // default sort column
      columnDefs : [ {
        "targets" : actionsCol,
        "orderable" : actionsCol < 0 ? true : false
      } ], // exclude columns from sorting
      // bLengthChange : false, // page size
      // bPaginate : false, // pagination
      // bFilter : true, // table filter
      // bSort : true, // sort
      // bInfo : true, // items info
      bAutoWidth : false, // width
      // responsive: true,
      // "autoWidth": true,
      scrollY : "310px",
      scrollX : true,
      scrollCollapse : true,
      paging : false,
      language : {
        "emptyTable" : jsMessages['message.no.records.available']
      }
    });

    // new $.fn.dataTable.FixedHeader(dtTable, {
    // "offsetTop" : 40
    // });

    new $.fn.dataTable.FixedColumns(dtTable, {
      "leftColumns" : 2
    });

    // $(dtTable).DataTable().columns.adjust();

    // on row selection
    $('#' + tableId + ' tbody').on('click', 'tr', function() {
      // console.log($(this));
      /*
       * if (hasRadio) { var radioInput = $('input:radio[name=' + rowKey + '][value=' + $(this).context.id + ']'); // console.log(radioInput); $(radioInput).iCheck('check'); }
       */

      /*
       * if (buttons && $.isArray(buttons)) { $.each(buttons, function(index, value) { console.log(value.id); $('#' + value.id).removeAttr("disabled"); }); }
       */

      /*
       * if ($(this).hasClass('active')) { $(this).removeClass('active'); } else { if (dtTable) { dtTable.$('tr.active').removeClass('active'); } $(this).addClass('active'); }
       */
    });

    // bind actions to buttons
    if (buttons && $.isArray(buttons)) {
      $.each(buttons, function(index, value) {
        $('#' + value.id).click(function() {
          // console.log(formId);
          $('#' + formId).attr('action', value.action);
        });
      });
    }

    $('.dropdown-menu-edit').each(function(index) {

      var key = $(this).parent().get(0).id;
      var keys = createKeysArray(entityListType, key);

      $(this).find('a').on("click", function(e) {
        e.preventDefault();
        var url = createActionUrl(entityListType, 'edit', actionMap.edit, keys);
        $('#' + formId).attr('action', url);
        // console.log($('#' + formId).attr('action'));
        $('#' + formId).submit();
      });

    });

    $('.dropdown-menu-view').each(function(index) {

      var key = $(this).parent().get(0).id;
      var keys = createKeysArray(entityListType, key);

      $(this).find('a').on("click", function(e) {
        e.preventDefault();
        var url = createActionUrl(entityListType, 'view', actionMap.view, keys);
        $('#' + formId).attr('action', url);
        // console.log($('#' + formId).attr('action'));
        $('#' + formId).submit();
      });

    });

    $('.dropdown-menu-delete').each(function(index) {

      var key = $(this).parent().get(0).id;
      var keys = createKeysArray(entityListType, key);

      $(this).find('a').on("click", function(e) {
        e.preventDefault();

        BootstrapDialog.confirm(jsMessages['message.delete.confirmation'], function(result) {
          if (result) {
            e.preventDefault();
            var url = createActionUrl(entityListType, 'del', actionMap.del, keys);
            $('#' + formId).attr('action', url);
            // console.log($('#' + formId).attr('action'));
            $('#' + formId).submit();
          }
        });
      });

    });

  };

  var createKeysArray = function(entityListType, key) {

    var keys = [];
    if (entityListType === 'events') {
      keys = key.split("|", 6);
    } else if (entityListType === 'fields') {
      keys = key.split("|", 3);
    } else {
      keys[0] = key;
    }

    // console.log(keys);
    return keys;
  };

  var createActionUrl = function(entityListType, actionType, action, keys) {

    // console.log(keys);
    var url = "";

    if (entityListType === 'events') {
      url = action + '/' + keys[1] + '/' + keys[2] + '/' + keys[3] + '/' + keys[4] + '/' + keys[5];
    } else if (entityListType === 'fields') {
      url = action + '/' + keys[1] + '/' + keys[2];
    } else {
      url = action + '/' + keys[0];
    }

    if (actionType === 'edit') {
      url = url + '/UPDATE';
    } else if (actionType === 'view') {
      url = url + '/READ';
    }

    return url;

  };

  // public member variables and methods
  return {

    initializePage : function() {
      iCheckNature();
      toggleSuccessAlerts();
      addCustomValidations();
    },

    toggleMenuTab : function(menuId) {
      toggleMenu(menuId);
    },

    addTableWidget : function(options) {
      createTable(options);
    }
  }
};

com.transerainc.ada.Util = function() {
  // private member variables and methods

  // public member variables and methods
  return {

    ajax : function(url, method, async, data, dataType, doneCallBack, failCallBack) {
      var request = $.ajax({
        url : url,
        method : method,
        async : async,
        data : data,
        dataType : dataType
      });
      request.done(doneCallBack);
      request.fail(failCallBack);
    },

    get : function(url, data, dataType, doneCallBack, failCallBack) {
      this.ajax(url, 'GET', true, data, dataType, doneCallBack, failCallBack);
    },

    post : function(url, data, dataType, doneCallBack, failCallBack) {
      this.ajax(url, 'POST', true, data, dataType, doneCallBack, failCallBack);
    },

    getJson : function(url, data, doneCallBack, failCallBack) {
      this.ajax(url, 'GET', true, data, 'json', doneCallBack, failCallBack);
    }

  }
}();