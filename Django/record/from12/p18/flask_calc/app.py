from flask import Flask, render_template, request, jsonify
import ast
import operator as op

app = Flask(__name__)

# Allowed operations
OPS = {
    ast.Add: op.add,
    ast.Sub: op.sub,
    ast.Mult: op.mul,
    ast.Div: op.truediv,
    ast.USub: op.neg,
    ast.UAdd: op.pos,
}

def safe_eval(expr: str) -> float:
    """
    Safely evaluate math expressions with + - * / parentheses and decimals.
    Rejects everything else.
    """
    expr = expr.strip()
    if not expr:
        raise ValueError("Empty expression")

    node = ast.parse(expr, mode="eval")

    def _eval(n):
        if isinstance(n, ast.Expression):
            return _eval(n.body)

        # numbers
        if isinstance(n, ast.Constant) and isinstance(n.value, (int, float)):
            return n.value

        # unary +/-
        if isinstance(n, ast.UnaryOp) and type(n.op) in OPS:
            return OPS[type(n.op)](_eval(n.operand))

        # binary ops
        if isinstance(n, ast.BinOp) and type(n.op) in OPS:
            left = _eval(n.left)
            right = _eval(n.right)
            if isinstance(n.op, ast.Div) and right == 0:
                raise ZeroDivisionError("Division by zero")
            return OPS[type(n.op)](left, right)

        raise ValueError("Invalid expression")

    return _eval(node)

@app.get("/")
def home():
    return render_template("index.html")

@app.post("/calculate")
def calculate():
    data = request.get_json(silent=True) or {}
    expr = data.get("expr", "")

    try:
        result = safe_eval(expr)
        return jsonify({"ok": True, "result": result})
    except ZeroDivisionError:
        return jsonify({"ok": False, "error": "Division by zero"}), 400
    except Exception:
        return jsonify({"ok": False, "error": "Invalid expression"}), 400

if __name__ == "__main__":
    app.run(debug=True)