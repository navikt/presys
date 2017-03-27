import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { fetchAllDocuments, fetchDocument } from 'actions/documentActions';
import DocumentList from 'components/behandling/info/DocumentList';

class DocumentIndex extends Component {

  constructor() {
    super();
    this.selectDocument = this.selectDocument.bind(this);
  }

  componentWillMount() {
    const saksnummerUrlParam = this.props.params.saksnummer;
    this.props.fetchAllDocuments({ snr: saksnummerUrlParam });
  }

  selectDocument(e, id, document) {
    this.props.fetchDocument({
      dokumentId: document.dokumentId,
      journalpostId: document.journalpostId,
    });
  }

  render() {
    if (!this.props.documentResultReceived) {
      return null;
    }

    return <DocumentList documents={this.props.documents} selectDocumentCallback={this.selectDocument} />;
  }
}

DocumentIndex.propTypes = {
  documents: React.PropTypes.arrayOf(React.PropTypes.shape({
    journalpostId: React.PropTypes.string.isRequired,
    dokumentId: React.PropTypes.string.isRequired,
    dokumentType: React.PropTypes.string.isRequired,
    tidspunkt: React.PropTypes.string.isRequired,
  })).isRequired,
  documentResultReceived: React.PropTypes.bool.isRequired,
  params: React.PropTypes.shape({
    saksnummer: React.PropTypes.string.isRequired,
  }).isRequired,
  fetchAllDocuments: React.PropTypes.func.isRequired,
  fetchDocument: React.PropTypes.func.isRequired,
};

const mapStateToProps = state => ({
  documents: state.default.documentContext.documents,
  documentResultReceived: state.default.documentContext.documentResultReceived,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, fetchAllDocuments, fetchDocument }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(DocumentIndex);
