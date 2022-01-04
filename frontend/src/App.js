
import React, {Component} from 'react';
import Select from 'react-select';
import Card from 'react-bootstrap/Card';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
        cats: [],
        age: "",
        path: "",
        name: ""
    }
  }

   async componentDidMount() {
    const URL = "http://localhost:4567/";
    await fetch(URL + "get-cats")
      .then(res => res.json())
      .then(data => {
        let elements = [];
        if (data === null) return;
        data.forEach(element => {
            const name = {'value': element.name, 'label': element.name};
            console.log(name);
            elements.push(name);
        });
        this.setState({
          cats: elements
        });
      });
    console.log("cats: " + this.state.cats);
  }

  async getCat(name) {
      console.log(name);
      const URL = "http://localhost:4567/";
      let cat = await fetch(URL + 'find-cat?name=' + name);
      let resolved = await cat.json();
      this.setState({
          age: resolved.age,
          path: resolved.path,
          name: resolved.name
      })
      console.log(resolved.path)
  }

  render() {
    console.log(this.state.cats);
    let card = this.state.name === "" ? <div/> :
        <Card style={{ width: '18rem' }}>
            <Card.Img variant="top" src={this.state.path} />
            <Card.Body>
                <Card.Title>{this.state.name}</Card.Title>
                <Card.Text> Age:
                    {" " + this.state.age}
                </Card.Text>
            </Card.Body>
        </Card>;
    return (
        <div className="App">
          <Select className="select" options={this.state.cats} onChange={(value) => {this.getCat(value.value)}} />
            {card}
        </div>
    );
  }
}

export default App;
